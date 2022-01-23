package io.falu.models.messages;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import io.falu.common.RangeFilteringOptions;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Options for filtering and pagination of messages.
 */
@SuperBuilder
public class MessagesListOptions extends BasicListOptions {

    /**
     * Range filter options for ${Message.delivered} property.
     */
    private RangeFilteringOptions<Date> delivered;

    /**
     * Filter options for${Message.status} property.
     */
    private String[] status;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values
                .add("status", status)
                .add("delivered", values.fromRange(delivered));
    }
}
