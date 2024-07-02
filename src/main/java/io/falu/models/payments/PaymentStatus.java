package io.falu.models.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The status of a payment.
 */
public enum PaymentStatus {
    @JsonProperty("pending")
    PENDING,
    @JsonProperty("succeeded")
    SUCCEEDED,
    @JsonProperty("failed")
    FAILED
}
