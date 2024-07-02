package io.falu.models.transfers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The medium used for the transfer.
 */
public enum TransferType {
    @JsonProperty("mpesa")
    MPESA
}
