package io.falu.models.payments.refunds;

import com.google.gson.annotations.SerializedName;

/**
 * The reason for refunding a payment.
 */
public enum PaymentRefundReason {
    @SerializedName("duplicate")
    DUPLICATE,

    @SerializedName("fraudulent")
    FRAUDULENT,

    @SerializedName("customerRequested")
    CUSTOMER_REQUESTED,

    @SerializedName("other")
    OTHER
}
