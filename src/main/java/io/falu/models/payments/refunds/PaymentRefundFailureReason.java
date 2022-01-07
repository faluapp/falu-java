package io.falu.models.payments.refunds;

import com.google.gson.annotations.SerializedName;

/**
 * Reason for failure of a payment refund.
 */
public enum PaymentRefundFailureReason {
    @SerializedName("unknown")
    UNKNOWN,
    @SerializedName("insufficient_balance")
    INSUFFICIENT_BALANCE,
    @SerializedName("authentication_error")
    AUTHENTICATION_ERROR,
    @SerializedName("amount_out_of_bound")
    AMOUNT_OUT_OF_BOUND,
    @SerializedName("timeout")
    TIMEOUT,
    @SerializedName("other")
    OTHER
}
