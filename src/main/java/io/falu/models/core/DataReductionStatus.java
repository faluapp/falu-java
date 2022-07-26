package io.falu.models.core;

import com.google.gson.annotations.SerializedName;

public enum DataReductionStatus {
    @SerializedName("redacted")
    REDACTED,
    @SerializedName("processing")
    PROCESSING
}
