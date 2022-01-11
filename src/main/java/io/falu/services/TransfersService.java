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

    /**
     * Get Transfers.
     *
     * @param callback the result object for the request.
     */
    public void getTransfers(@NotNull ApiResultCallback<Transfer[]> callback) {
        try {
            ResourceResponse<Transfer[]> response = getApiClient().getTransfers();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /**
     * Create Transfer.
     *
     * @param request  the request object.
     * @param callback the result object for the request.
     */
    public void createTransfer(@NotNull TransferCreateRequest request, @NotNull ApiResultCallback<Transfer> callback) {
        try {
            ResourceResponse<Transfer> response = getApiClient().createTransfer(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /**
     * Get Transfer.
     *
     * @param transferId the unique identifier of the transfer.
     * @param callback   the result object for the request.
     */
    public void getTransfer(@NotNull String transferId, @NotNull ApiResultCallback<Transfer> callback) {
        try {
            ResourceResponse<Transfer> response = getApiClient().getTransfer(transferId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /**
     * Get Transfer Reversals.
     *
     * @param callback the result object for the request.
     */
    public void getTransferReversals(@NotNull ApiResultCallback<TransferReversal[]> callback) {
        try {
            ResourceResponse<TransferReversal[]> response = getApiClient().getTransferReversals();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /**
     * Create Transfer Reversals.
     *
     * @param request  the request object.
     * @param callback the result object for the request.
     */
    public void createTransferReversal(@NotNull TransferReversalCreateRequest request, @NotNull ApiResultCallback<TransferReversal> callback) {
        try {
            ResourceResponse<TransferReversal> response = getApiClient().createTransferReversal(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /**
     * Get Transfer Reversal.
     *
     * @param reversalId the unique identifier of the reversal.
     * @param callback   the result object for the request.
     */
    public void getTransferReversal(@NotNull String reversalId, @NotNull ApiResultCallback<TransferReversal> callback) {
        try {
            ResourceResponse<TransferReversal> response = getApiClient().getTransferReversal(reversalId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
