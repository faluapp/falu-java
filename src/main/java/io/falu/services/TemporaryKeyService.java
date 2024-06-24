package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.temporaryKeys.TemporaryKey;
import io.falu.models.temporaryKeys.TemporaryKeyCreateOptions;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class TemporaryKeyService extends BaseApiService {

    public TemporaryKeyService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Create a temporary key.
     *
     * @param request        The request object.
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<TemporaryKey> createTemporaryKey(@NotNull TemporaryKeyCreateOptions request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createTemporaryKey(request, requestOptions);
    }

    /**
     * Delete a temporary key.
     *
     * @param id Unique identifier for the temporary key
     * @param requestOptions Additional info to add to the request.
     */
    public ResourceResponse<?> deleteTemporaryKey(@NotNull String id, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().deleteTemporaryKey(id, requestOptions);
    }
}
