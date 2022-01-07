package io.falu.models.payments.refunds;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Details about failure of a payment refund.
 */
@Getter
@NoArgsConstructor
public class PaymentRefundFailure {

    /**
     * Reason for failure.
     */
    private PaymentRefundFailureReason reason;

    /**
     * Time at which failure occurred.
     */
    private Date timestamp;

    /**
     * Failure message as received from the provider.
     */
    private String detail;
}
