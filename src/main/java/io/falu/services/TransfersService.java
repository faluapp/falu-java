package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.transfers.Transfer;
import io.falu.models.transfers.TransferCreateRequest;
import io.falu.models.transfers.TransferListOptions;
import io.falu.models.transfers.TransferPatchModel;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateRequest;
import io.falu.models.transfers.reversals.TransferReversalPatchModel;
import io.falu.models.transfers.reversals.TransferReversalsListOptions;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class TransfersService extends BaseApiService {
    public TransfersService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get Transfers.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Transfer[]> getTransfers(@Nullable TransferListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getTransfers(listOptions, requestOptions);
    }

    /**
     * Create Transfer.
     *
     * @param request        the request object.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Transfer> createTransfer(@NotNull TransferCreateRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createTransfer(request, requestOptions);
    }

    /**
     * Get Transfer.
     *
     * @param transferId     the unique identifier of the transfer.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Transfer> getTransfer(@NotNull String transferId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getTransfer(transferId, requestOptions);
    }

    /**
     * Get Transfer.
     *
     * @param transferId     the unique identifier of the transfer.
     * @param patch          the patch document.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Transfer> updateTransfer(@NotNull String transferId, @NotNull JsonPatchDocument<TransferPatchModel> patch, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().updateTransfer(transferId, patch, requestOptions);
    }

    /**
     * Get Transfer Reversals.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<TransferReversal[]> getTransferReversals(@Nullable TransferReversalsListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getTransferReversals(listOptions, requestOptions);
    }

    /**
     * Create Transfer Reversals.
     *
     * @param request        the request object.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<TransferReversal> createTransferReversal(@NotNull TransferReversalCreateRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createTransferReversal(request, requestOptions);
    }

    /**
     * Get Transfer Reversal.
     *
     * @param reversalId     the unique identifier of the reversal.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<TransferReversal> getTransferReversal(@NotNull String reversalId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getTransferReversal(reversalId, requestOptions);
    }

    /**
     * Update Transfer Reversal.
     *
     * @param reversalId     the unique identifier of the reversal.
     * @param patch          the patch document.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<TransferReversal> updateTransferReversal(@NotNull String reversalId,
        @NotNull TransferReversalPatchModel patchModel, @Nullable RequestOptions requestOptions) throws IOException {

        return getApiClient().updateTransferReversal(reversalId, patchModel, requestOptions);
    }
}
