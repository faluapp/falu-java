package io.falu.models.payments.refunds;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The reason for refunding a payment.
 */
public enum PaymentRefundReason {
    @JsonProperty("duplicate")
    DUPLICATE,

    @JsonProperty("fraudulent")
    FRAUDULENT,

    @JsonProperty("customerRequested")
    CUSTOMER_REQUESTED,

    @JsonProperty("other")
    OTHER
}
