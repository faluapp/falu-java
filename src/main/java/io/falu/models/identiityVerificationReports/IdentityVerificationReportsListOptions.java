package io.falu.models.identiityVerificationReports;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class IdentityVerificationReportsListOptions extends BasicListOptions {

    private String verification;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values.add("verification", verification);
    }
}
