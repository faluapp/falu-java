package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.identity.IdentityRecord;
import io.falu.models.identity.IdentitySearchModel;
import org.jetbrains.annotations.NotNull;

public class IdentityService extends BaseApiService {
    public IdentityService(FaluClientOptions options) {
        super(options);
    }

    public void searchIdentity(@NotNull IdentitySearchModel searchModel, @NotNull ApiResultCallback<IdentityRecord> callback) {
        try {
            ResourceResponse<IdentityRecord> response = getApiClient().searchIdentity(searchModel);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
