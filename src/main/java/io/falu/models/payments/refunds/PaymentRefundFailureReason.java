package io.falu.models.payments.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reason for failure of a payment refund.
 */
public enum PaymentRefundFailureReason {
    @JsonProperty("unknown")
    UNKNOWN,
    @JsonProperty("insufficient_balance")
    INSUFFICIENT_BALANCE,
    @JsonProperty("authentication_error")
    AUTHENTICATION_ERROR,
    @JsonProperty("amount_out_of_bound")
    AMOUNT_OUT_OF_BOUND,
    @JsonProperty("timeout")
    TIMEOUT,
    @JsonProperty("other")
    OTHER
}
