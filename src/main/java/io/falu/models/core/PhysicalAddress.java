package io.falu.models.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents a physical address.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalAddress {

    /**
     * The first line.
     * Also referred to as the <c>street-address</c>.
     */
    private String line1;

    /**
     * The second line.
     * Also referred to as the <c>apt, building, suite no. etc.</c>
     */
    private String line2;

    /**
     * The city.
     */
    private String city;

    /**
     * The postal code or zip code.
     * Each country has its way of denoting postal codes.
     */
    private String postalCode;

    /**
     * The state or province.
     * Also referred to as the <c>province</c>
     */
    private String state;

    /**
     * The country.
     */
    private String country;
}
