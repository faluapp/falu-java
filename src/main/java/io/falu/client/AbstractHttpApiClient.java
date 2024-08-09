package io.falu.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.falu.client.adapters.OptionalSerializer;
import io.falu.client.headers.IAuthenticationProvider;
import io.falu.networking.AppDetailsInterceptor;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * An abstraction of an HTTP client for accessing APIs built by TINGLE
 */
public class AbstractHttpApiClient {
    protected static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json; charset=utf-8");
    protected static final MediaType MEDIA_TYPE_TEXT_JSON = MediaType.get("text/json");
    protected static final MediaType MEDIA_TYPE_MERGE_PATCH_JSON = MediaType.get("application/merge-patch+json");
    protected static final MediaType MEDIA_TYPE_PLUS_JSON = MediaType.get("application/*+json");

    private final OkHttpClient backChannel;
    private ObjectMapper objectMapper;

    /**
     * Creates an instance of @[AbstractHttpApiClient]
     *
     * @param authenticationProvider the provider to use for authentication
     */
    public AbstractHttpApiClient(@NotNull IAuthenticationProvider authenticationProvider, AppDetailsInterceptor interceptor, Boolean enableDebug) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
            .addInterceptor(authenticationProvider)
            .addInterceptor(interceptor)
            .followRedirects(false)
            .connectTimeout(50, TimeUnit.SECONDS) // default is 50 seconds
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50, TimeUnit.SECONDS);

        if (enableDebug != null && enableDebug) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        backChannel = buildBackChannel(builder);

        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Optional.class, new OptionalSerializer());
        objectMapper.registerModule(module);
    }

    protected OkHttpClient buildBackChannel(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @SuppressWarnings("unchecked")
    protected <TResult> ResourceResponse<TResult> execute(Request.Builder builder, Class<TResult> classOfTResult) throws IOException {
        Request request = builder.build();
        Response response = backChannel.newCall(request).execute();

        HttpResponseProblem error = null;
        TResult result = null;

        ResponseBody body = response.body();
        Integer code = response.code();

        if (body != null) {
            switch (code) {
                case 200:
                case 201:
                case 204: {
                    if (classOfTResult != null) {
                        result = objectMapper.readValue(body.charStream(), classOfTResult);
                    }
                }
                case 400: {
                    error = objectMapper.readValue(body.charStream(), HttpResponseProblem.class);
                }
            }

            // close the body stream
            body.close();
        }

        return (ResourceResponse<TResult>) ResourceResponse.builder()
            .statusCode(code)
            .headers(response.headers())
            .resource(result)
            .error(error)
            .build();
    }

    protected String makeJson(@Nullable Object o) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    protected String makeJson(@Nullable Object o, ObjectMapper objectMapper) {
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
