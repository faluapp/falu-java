package io.falu.models.core;

import lombok.Getter;

/**
 * Represents redaction information of an object.
 */
@Getter
public class DataReduction {
    /**
     * Indicates whether the object and its related objects have been redacted or not.
     */
    private DataReductionStatus status;
}
