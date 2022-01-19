package io.falu.models.transfers.reversals;

import io.falu.models.FaluModel;
import io.falu.models.payments.refunds.PaymentRefundFailure;
import io.falu.models.payments.refunds.PaymentRefundMpesaDetails;
import io.falu.models.payments.refunds.PaymentRefundReason;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a reversal of a Transfer.
 */
@Getter
@NoArgsConstructor
public class TransferReversal extends FaluModel {

    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Identifier of the transfer reversed.
     */
    private String transfer;

    /**
     * Amount reversed in smallest currency unit.
     */
    private long amount;

    /**
     * The reason for reversing a transfer.
     */
    private PaymentRefundReason reason;

    /**
     * Represents the details for an MPESA transfer reversal.
     */
    private PaymentRefundMpesaDetails mpesa;

    /**
     * Details about failure if the reversal is in failed state.
     */
    private PaymentRefundFailure failure;
}
