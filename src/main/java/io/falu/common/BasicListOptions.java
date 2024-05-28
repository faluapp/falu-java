package io.falu.common;

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
    private String[] sorting;

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
    private RangeFilteringOptions<Date> updated;


    public void populate(QueryValues values) {
        if (values == null) return;

        values
                .add("sort", sorting)
                .add("count", count)
                .add("created", new QueryValues().fromRange(created))
                .add("updated", new QueryValues().fromRange(updated));
    }
}
