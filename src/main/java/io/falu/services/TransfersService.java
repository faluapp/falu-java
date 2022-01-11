package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.transfers.Transfer;
import io.falu.models.transfers.TransferCreateRequest;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateRequest;
import org.jetbrains.annotations.NotNull;

public class TransfersService extends BaseApiService {
    public TransfersService(FaluClientOptions options) {
        super(options);
    }

    public void getTransfers(@NotNull ApiResultCallback<Transfer[]> callback) {
        try {
            ResourceResponse<Transfer[]> response = getApiClient().getTransfers();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createTransfer(@NotNull TransferCreateRequest request, @NotNull ApiResultCallback<Transfer> callback) {
        try {
            ResourceResponse<Transfer> response = getApiClient().createTransfer(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getTransfer(@NotNull String refundId, @NotNull ApiResultCallback<Transfer> callback) {
        try {
            ResourceResponse<Transfer> response = getApiClient().getTransfer(refundId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getTransferReversals(@NotNull ApiResultCallback<TransferReversal[]> callback) {
        try {
            ResourceResponse<TransferReversal[]> response = getApiClient().getTransferReversals();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createTransferReversal(@NotNull TransferReversalCreateRequest request, @NotNull ApiResultCallback<TransferReversal> callback) {
        try {
            ResourceResponse<TransferReversal> response = getApiClient().createTransferReversal(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getTransferReversal(@NotNull String reversalId, @NotNull ApiResultCallback<TransferReversal> callback) {
        try {
            ResourceResponse<TransferReversal> response = getApiClient().getTransferReversal(reversalId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
