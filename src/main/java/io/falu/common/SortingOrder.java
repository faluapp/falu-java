package io.falu.common;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The sorting order for a list operation.
 */
public enum SortingOrder {
    @JsonProperty("ascending")
    ASCENDING,
    @JsonProperty("descending")
    DESCENDING
}
