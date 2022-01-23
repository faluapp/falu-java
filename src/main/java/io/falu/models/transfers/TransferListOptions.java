package io.falu.models.transfers;

import io.falu.common.BasicListOptionsWithMoney;
import io.falu.common.QueryValues;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of transfers.
 */
@SuperBuilder
public class TransferListOptions extends BasicListOptionsWithMoney {
    /**
     * Filter options for ${Transfer.status} property.
     */
    private String[] status;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("status", status);
    }
}
