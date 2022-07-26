package io.falu.services;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class IdentityVerificationListOptions extends BasicListOptions {

    private String[] status;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("status", status);
    }
}
