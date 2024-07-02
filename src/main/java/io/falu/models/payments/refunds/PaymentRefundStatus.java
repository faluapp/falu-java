package io.falu.models.payments.refunds;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The status of a payment refund.
 */
public enum PaymentRefundStatus {
    @JsonProperty("pending")
    PENDING,

    @JsonProperty("inTransit")
    IN_TRANSIT,

    @JsonProperty("succeeded")
    SUCCEEDED,

    @JsonProperty("failed")
    FAILED
}
