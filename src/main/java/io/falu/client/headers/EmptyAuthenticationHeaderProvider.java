package io.falu.client.headers;

import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * The default implementation for @[IAuthenticationProvider] which does not modify the request message at all.
 * Use this to make requests to a service that do not need authentication or to test authentication.
 * This can also be used to find out the supported authentication methods as is presented in the 'WWW-Authentication' header
 * of a response message @[software.tingle.api.ResourceResponse]
 */
public class EmptyAuthenticationHeaderProvider implements IAuthenticationProvider {
    /**
     * Set authorization data to a request before executing
     *
     * @param chain the request execution chain
     */
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
