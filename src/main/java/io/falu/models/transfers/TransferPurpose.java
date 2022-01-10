package io.falu.models.transfers;

import com.google.gson.annotations.SerializedName;

/**
 * The purpose of a transfer.
 */
public enum TransferPurpose {
    @SerializedName("business")
    BUSINESS,
    @SerializedName("salary")
    SALARY,
    @SerializedName("promotion")
    PROMOTION
}
