package io.falu.models.transfers;

import io.falu.models.FaluModel;
import io.falu.models.payments.refunds.PaymentRefundStatus;
import lombok.Getter;

/**
 * Represents a transaction made by the business to customer or another business.
 */
@Getter
public class Transfer extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Amount of the transfer in smallest currency unit.
     */
    private long amount;

    /**
     * The status of a transfer.
     */
    private PaymentRefundStatus status;

    /**
     * The medium used for the transfer.
     */
    private TransferType type;

    /**
     * The purpose of a transfer.
     */
    private TransferPurpose purpose;

    /**
     * Represents the provider details for a MPESA transfer.
     */
    private TransferMpesaDetails mpesa;
}
