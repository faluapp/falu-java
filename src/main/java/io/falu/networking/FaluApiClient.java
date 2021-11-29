package io.falu.networking;

import io.falu.client.AbstractHttpApiClient;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

public class FaluApiClient extends AbstractHttpApiClient {
    private Boolean enableLogging;

    FaluApiClient(String key, Boolean enableLogging) {
        this.enableLogging = enableLogging;
    }

    @Override
    protected OkHttpClient buildBackChannel(OkHttpClient.Builder builder) {
        builder
                .followRedirects(false)
                .connectTimeout(50, TimeUnit.SECONDS) // default is 50 seconds
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS);

        if (enableLogging) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        return super.buildBackChannel(builder);
    }
}
