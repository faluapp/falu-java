package io.falu.models.payments.refunds;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of list payment refunds operation.
 */
@SuperBuilder
public class PaymentRefundsListOptions extends BasicListOptions {
    /**
     * Filter options for ${PaymentRefund.status} property.
     */
    private String[] status;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("status", status);
    }
}
