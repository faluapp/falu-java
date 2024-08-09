package io.falu.client.headers;

import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Interceptor that provides retry logic based on the presence of the "X-Should-Retry" header
 * and certain HTTP status codes.
 */
public class RetriesHeaderProvider implements IAuthenticationProvider {
    private final int maxRetries;

    /**
     * Constructor to initialize the retry provider.
     *
     * @param maxRetries  Maximum number of retries to attempt.
     */
    public RetriesHeaderProvider(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    /**
     * Intercept the request and apply retry logic based on the response.
     *
     * @param chain The request chain.
     * @return The final response after retries.
     * @throws IOException If an I/O error occurs during request processing.
     */
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        int retryCount = 0;

        while (shouldRetry(response) && retryCount < maxRetries) {
            retryCount++;
            try {
                TimeUnit.MILLISECONDS.sleep(500); // Delay between retries
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException("Retry interrupted", e);
            }
            response = chain.proceed(request);
        }

        return response;
    }

    /**
     * Determines whether a retry should be attempted based on the response.
     *
     * @param response The HTTP response.
     * @return True if the request should be retried, otherwise false.
     */
    private boolean shouldRetry(Response response) {
        String headerValue = response.header("X-Should-Retry");
        if (Boolean.parseBoolean(headerValue)) {
            return true;
        }
        int statusCode = response.code();
        return statusCode == 409 || statusCode == 408 || (statusCode >= 500 && statusCode < 600);
    }
}
