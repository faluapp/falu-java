package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.moneyBalances.MoneyBalance;
import org.jetbrains.annotations.NotNull;

public class MoneyBalancesService extends BaseApiService {
    public MoneyBalancesService(FaluClientOptions options) {
        super(options);
    }

    /**
     * Get money balances.
     *
     * @param callback the result object for the request.
     */
    public void getMoneyBalances(@NotNull ApiResultCallback<MoneyBalance> callback) {
        try {
            ResourceResponse<MoneyBalance> response = getApiClient().getMoneyBalances();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }


    /**
     * Refresh money balances.
     *
     * @param callback the result object for the request.
     */
    public void refreshMoneyBalances(@NotNull ApiResultCallback<MoneyBalance> callback) {
        try {
            ResourceResponse<MoneyBalance> response = getApiClient().refreshMoneyBalances();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
