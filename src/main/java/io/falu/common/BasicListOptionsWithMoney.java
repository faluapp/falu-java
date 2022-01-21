package io.falu.common;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Standard options for filtering and pagination in list operations with money.
 */
@NoArgsConstructor
@SuperBuilder
public class BasicListOptionsWithMoney extends BasicListOptions {

    /**
     * Filter options for currency property
     */
    private String currency;

    /**
     * Filter options for amount property.
     */
    private RangeFilteringOptions<Long> amount;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);

        values
                .add("currency", currency)
                .add("amount", values.fromRange(amount));
    }
}
