package io.falu.models.payments;

import com.google.gson.annotations.SerializedName;

/**
 * The status of a payment.
 */
public enum PaymentStatus {
    @SerializedName("pending")
    PENDING,
    @SerializedName("succeeded")
    SUCCEEDED,
    @SerializedName("failed")
    FAILED
}
