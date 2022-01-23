package io.falu.models.payments.authorization;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.experimental.SuperBuilder;

/**
 * Options for filtering and pagination of payment authorizations.
 */
@SuperBuilder
public class PaymentAuthorizationsListOptions extends BasicListOptions {
    /**
     * Filter options for ${PaymentAuthorization.status} property.
     */
    private String[] status;

    /**
     * Filter options for ${PaymentAuthorization.Approved} property.
     */
    private Boolean approved;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values
                .add("status", status)
                .add("approved", approved);
    }
}
