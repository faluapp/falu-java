package io.falu.networking;

import io.falu.client.headers.AuthenticationHeaderProvider;
import okhttp3.Request;

public class FaluAuthenticationHeaderProvider extends AuthenticationHeaderProvider {
    private final String key;

    public FaluAuthenticationHeaderProvider(String key) {
        this.key = key;
    }

    @Override
    protected String getParameter(Request.Builder request) {
        return key;
    }
}
