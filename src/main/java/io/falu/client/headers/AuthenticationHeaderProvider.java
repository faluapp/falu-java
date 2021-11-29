package io.falu.client.headers;

import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Implementation of @[IAuthenticationProvider] which sets the Authorization header using the scheme and parameter separated by a space.
 * The parameter set is gotten from the abstract method @[.getParameter].
 */
public abstract class AuthenticationHeaderProvider implements IAuthenticationProvider {
    private static final String DEFAULT_SCHEME = "Bearer";

    private final String scheme;

    /**
     * Creates an instance of @[AuthenticationHeaderProvider]
     *
     * @param scheme the scheme to be used in the Authorization header as the prefix for the header value
     */
    public AuthenticationHeaderProvider(@Nullable String scheme) {
        this.scheme = scheme == null ? DEFAULT_SCHEME : scheme;
    }

    /**
     * Set authorization data to a request before executing
     *
     * @param chain the request execution chain
     */
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request.Builder builder = chain
                .request()
                .newBuilder();

        String parameter = getParameter(builder);
        Request request = builder
                .header("Authorization", scheme + " " + parameter)
                .build();
        return chain.proceed(request);
    }

    /**
     * Gets the authentication parameter value.
     *
     * @param request the request message to be authorized
     * @return the parameter
     */
    protected abstract String getParameter(Request.Builder request);
}
