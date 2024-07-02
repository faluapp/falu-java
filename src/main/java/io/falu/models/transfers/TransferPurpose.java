package io.falu.models.transfers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The purpose of a transfer.
 */
public enum TransferPurpose {
    @JsonProperty("business")
    BUSINESS,
    @JsonProperty("salary")
    SALARY,
    @JsonProperty("promotion")
    PROMOTION
}
