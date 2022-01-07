package io.falu.models.payments.refunds;

import com.google.gson.annotations.SerializedName;

/**
 * The status of a payment refund.
 */
public enum PaymentRefundStatus {
    @SerializedName("pending")
    PENDING,

    @SerializedName("inTransit")
    IN_TRANSIT,

    @SerializedName("succeeded")
    SUCCEEDED,

    @SerializedName("failed")
    FAILED
}
