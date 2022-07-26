package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.identity.IdentityRecord;
import io.falu.models.identity.IdentitySearchModel;
import io.falu.models.identity.MarketingListOptions;
import io.falu.models.identity.MarketingResult;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

@Deprecated(forRemoval = true)
public class IdentityService extends BaseApiService {
    public IdentityService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Search Identity.
     *
     * @param searchModel the request object.
     */
    public ResourceResponse<IdentityRecord> searchIdentity(@NotNull IdentitySearchModel searchModel, @Nullable RequestOptions options) throws IOException {
        return getApiClient().searchIdentity(searchModel, options);
    }

    /**
     * Get Marketing Results.
     *
     * @param listOptions the filter options.
     */
    public ResourceResponse<MarketingResult[]> getMarketingResults(MarketingListOptions listOptions, RequestOptions options) throws IOException {
        return getApiClient().fetchMarketingResults(listOptions, options);
    }
}
