package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.transfers.Transfer;
import io.falu.models.transfers.TransferCreateRequest;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateRequest;
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
    public ResourceResponse<Transfer[]> getTransfers(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getTransfers(requestOptions);
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
     * Get Transfer Reversals.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<TransferReversal[]> getTransferReversals(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getTransferReversals(requestOptions);
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
}
