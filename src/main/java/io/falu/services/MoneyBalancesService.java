package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.moneyBalances.MoneyBalance;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class MoneyBalancesService extends BaseApiService {
    public MoneyBalancesService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get money balances.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<MoneyBalance> getMoneyBalances(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getMoneyBalances(requestOptions);
    }


    /**
     * Refresh money balances.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<MoneyBalance> refreshMoneyBalances(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().refreshMoneyBalances(requestOptions);
    }
}
