package io.falu.common;

import com.google.gson.annotations.SerializedName;

/**
 * The sorting order for a list operation.
 */
public enum SortingOrder {
    @SerializedName("ascending")
    ASCENDING,
    @SerializedName("descending")
    DESCENDING
}
