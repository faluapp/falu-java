package io.falu.common;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Standard options for filtering and pagination in list operations.
 */
@NoArgsConstructor
@SuperBuilder
public class BasicListOptions {
    /**
     * The order to use for sorting the objects returned.
     */
    private String sort;

    /**
     * The maximum number of objects to return.
     */
    private Integer count;

    /**
     * Range filter options for property.
     */
    private RangeFilteringOptions<Date> created;

    /**
     * Range filter options for property.
     */
    private RangeFilteringOptions<Date> update;
}
