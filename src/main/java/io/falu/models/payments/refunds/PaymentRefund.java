package io.falu.models.payments.refunds;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a reversal of a Payment.
 */
@Getter
@NoArgsConstructor
public class PaymentRefund extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Identifier of the payment refunded.
     */
    private String paymentId;

    /**
     * Amount refunded in the smallest currency unit.
     */
    private long amount;

    /**
     * The reason for refunding a payment.
     */
    private PaymentRefundReason reason;

    /**
     * Details of the reversal if done via MPESA.
     * Only populated if the payment being reversed used an MPESA instrument.
     */
    private PaymentRefundMpesaDetails mpesa;

    /**
     * Details about failure if the reversal is in failed state.
     */
    private PaymentRefundFailure failure;

}
