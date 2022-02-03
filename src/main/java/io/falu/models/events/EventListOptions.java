package io.falu.models.events;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of events
 */
@SuperBuilder
public class EventListOptions extends BasicListOptions {
    private String[] type;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("type", type);
    }
}
