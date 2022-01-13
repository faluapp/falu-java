package io.falu.client;

import com.google.gson.Gson;
import io.falu.client.headers.IAuthenticationProvider;
import io.falu.networking.AppDetailsInterceptor;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * An abstraction of an HTTP client for accessing APIs built by TINGLE
 */
public class AbstractHttpApiClient {
    protected static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json; charset=utf-8");
    protected static final MediaType MEDIA_TYPE_TEXT_JSON = MediaType.get("text/json");
    protected static final MediaType MEDIA_TYPE_PATH_JSON = MediaType.get("application/json-path+json");
    protected static final MediaType MEDIA_TYPE_PLUS_JSON = MediaType.get("application/*+json");

    private final OkHttpClient backChannel;
    private final Gson gson = new Gson();

    /**
     * Creates an instance of @[AbstractHttpApiClient]
     *
     * @param authenticationProvider the provider to use for authentication
     */
    public AbstractHttpApiClient(@NotNull IAuthenticationProvider authenticationProvider, AppDetailsInterceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(authenticationProvider)
                .addInterceptor(interceptor)
                .followRedirects(false)
                .connectTimeout(50, TimeUnit.SECONDS) // default is 50 seconds
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS);


        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        backChannel = builder.build();
    }

//    /**
//     * Builds the back channel @[OkHttpClient] to be used by the client
//     *
//     * @param builder the prepared builder to extend
//     * @return an initialized back channel
//     */
//    protected synchronized OkHttpClient buildBackChannel(OkHttpClient.Builder builder) {
//        return builder.build();
//    }

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
                        result = gson.fromJson(body.charStream(), classOfTResult);
                    }
                }
                case 400: {
                    error = gson.fromJson(body.charStream(), HttpResponseProblem.class);
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
        return gson.toJson(o);
    }
}
