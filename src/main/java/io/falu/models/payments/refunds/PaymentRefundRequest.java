package io.falu.models.payments.refunds;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class PaymentRefundRequest {
    /**
     * Identifier of the payment to refund.
     */
    private String payment;

    /**
     * The reason for refunding a payment.
     */
    private PaymentRefundReason reason;
}
