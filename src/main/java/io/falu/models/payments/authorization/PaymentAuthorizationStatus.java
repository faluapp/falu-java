package io.falu.models.payments.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The status of a payment authorization.
 */
public enum PaymentAuthorizationStatus {
    /**
     * The authorization was created and is awaiting approval or was approved and is awaiting capture.
     */
    @JsonProperty("pending")
    PENDING,

    /**
     * The authorization was declined or captured.
     */
    @JsonProperty("closed")
    CLOSED,

    /**
     * The authorization was reversed by the payment provider or expired without capture.
     */
    @JsonProperty("reversed")
    REVERSED
}
