package io.falu.models.payments.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reason for a given status of payment authorization.
 */
public enum PaymentAuthorizationReason {
    /**
     * No authorization webhook endpoint is set.
     */
    @JsonProperty("default")
    DEFAULT,

    /**
     * Authorization webhook endpoint is invalid.
     */
    @JsonProperty("invalid")
    INVALID,

    /**
     * Authorization webhook endpoint was used to approve or decline.
     */
    @JsonProperty("realtime")
    REALTIME,

    /**
     * Synchronous webhook delivery to the authorization webhook endpoint failed.
     */
    @JsonProperty("failed")
    FAILED,
}
