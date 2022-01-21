package io.falu.models.identity;

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
public class MarketingListOptions {
    /**
     * Three-letter ISO country code, in lowercase, where the record exists.
     */
    private String country = "ken";

    /**
     * The gender of the entity.
     * When not specified, any gender is returned.
     */
    private Gender gender;

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
}
