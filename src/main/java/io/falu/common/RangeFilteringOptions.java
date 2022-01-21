package io.falu.common;

import org.jetbrains.annotations.Nullable;

/**
 * Standard options for range filtering
 */
public record RangeFilteringOptions<T>(T lessThan, T lessThanOrEqualTo, T greaterThan, T greaterThanOrEqualTo) {
    /**
     * Creates an instance of ${FilteringOptions<T>}
     *
     * @param lessThan             Option for less than
     * @param lessThanOrEqualTo    Option for less than or equal to
     * @param greaterThan          Option for greater than
     * @param greaterThanOrEqualTo Option for greater than or equal to
     */
    public RangeFilteringOptions(@Nullable T lessThan, @Nullable T lessThanOrEqualTo, T greaterThan, T greaterThanOrEqualTo) {
        this.lessThan = lessThan;
        this.greaterThan = greaterThan;
        this.lessThanOrEqualTo = lessThanOrEqualTo;
        this.greaterThanOrEqualTo = greaterThanOrEqualTo;
    }
}
