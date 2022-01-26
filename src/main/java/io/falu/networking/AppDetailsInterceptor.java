package io.falu.networking;

import io.falu.AppInformation;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * An @[Interceptor] that adds headers for the User Agent to a request before sending
 */
public class AppDetailsInterceptor implements Interceptor {

    private final AppInformation information;

    public AppDetailsInterceptor(AppInformation information) {
        this.information = information;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain
                .request()
                .newBuilder()
                .header("X-Falu-Version", "2022-01-01")
                .header("User-Agent", information.getUserAgent())
                .build();
        return chain.proceed(request);
    }
}
