package io.falu.models.payments;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of payments
 */
@SuperBuilder
public class PaymentsListOptions extends BasicListOptions {
    /**
     * Filter options for ${Payment.Status} property.
     */
    private String[] status;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values
                .add("status", status);
    }
}
