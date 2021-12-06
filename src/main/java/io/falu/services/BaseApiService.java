package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.networking.AppDetailsInterceptor;
import io.falu.networking.FaluApiClient;

abstract class BaseApiService {

    private final FaluApiClient apiClient;

    BaseApiService(FaluClientOptions options) {
        AppDetailsInterceptor appDetailsInterceptor = new AppDetailsInterceptor(options.getAppInformation());
        this.apiClient = new FaluApiClient(options);
    }

    private FaluApiClient getApiClient() {
        return apiClient;
    }


}
