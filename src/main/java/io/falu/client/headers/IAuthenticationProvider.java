package io.falu.client.headers;

import okhttp3.Interceptor;

/**
 * Contract for implementing authorization providers
 */
interface IAuthenticationProvider extends Interceptor {
}
