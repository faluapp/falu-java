package io.falu.models.core;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum DataReductionStatus {
    @JsonProperty("redacted")
    REDACTED,
    @JsonProperty("processing")
    PROCESSING
}
