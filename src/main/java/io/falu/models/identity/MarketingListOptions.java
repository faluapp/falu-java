package io.falu.models.identity;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import io.falu.common.RangeFilteringOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Options for filtering and pagination of identity marketing data.
 */
@Getter
@Setter
@SuperBuilder
public class MarketingListOptions extends BasicListOptions {
    /**
     * Three-letter ISO country code, in lowercase, where the record exists.
     */
    private String country;

    /**
     * The gender of the entity.
     * When not specified, any gender is returned.
     */
    private String gender;

    /**
     * Range filter options for birthday property but based on age.
     * Cannot be used with ${Birthday}
     */
    RangeFilteringOptions<Integer> age;

    /**
     * Range filter options for birthday property.
     * Cannot be used with ${Age}.
     */
    RangeFilteringOptions<Date> birthday;

    @Override
    public void populate(QueryValues values) {
        super.populate(values);
        values
                .add("country", country)
                .add("gender", gender)
                .add("age", new QueryValues().fromRange(age))
                .add("birthday", new QueryValues().fromRange(birthday));
    }
}
