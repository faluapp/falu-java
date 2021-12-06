package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.networking.AppDetailsInterceptor;
import io.falu.networking.FaluApiClient;
import org.jetbrains.annotations.NotNull;

abstract class BaseApiService {

    private final FaluApiClient apiClient;

    BaseApiService(FaluClientOptions options) {
        AppDetailsInterceptor appDetailsInterceptor = new AppDetailsInterceptor(options.getAppInformation());
        this.apiClient = new FaluApiClient(options);
    }

    protected FaluApiClient getApiClient() {
        return apiClient;
    }


    // handle falu Resource Response
    protected <TResource> void handleResponse(ResourceResponse<TResource> response, @NotNull ApiResultCallback<TResource> callback) {
        if (response != null && response.successful() && response.getResource() != null) {
            callback.onSuccess(response.getResource());
            return;
        }
        // TODO: handle responses
    }

    protected void dispatchError(Throwable throwable, @NotNull ApiResultCallback<Object> callback) {
        //callback.onError(throwable);
    }
}
