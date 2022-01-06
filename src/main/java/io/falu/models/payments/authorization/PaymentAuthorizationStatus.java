package io.falu.models.payments.authorization;

import com.google.gson.annotations.SerializedName;

/**
 * The status of a payment authorization.
 */
public enum PaymentAuthorizationStatus {
    /**
     * The authorization was created and is awaiting approval or was approved and is awaiting capture.
     */
    @SerializedName("pending")
    PENDING,

    /**
     * The authorization was declined or captured.
     */
    @SerializedName("closed")
    CLOSED,

    /**
     * The authorization was reversed by the payment provider or expired without capture.
     */
    @SerializedName("reversed")
    REVERSED
}
