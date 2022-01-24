package io.falu.common;

import org.jetbrains.annotations.Nullable;

/**
 * Standard options for range filtering
 */
public record RangeFilteringOptions<T>(T lessThan, T lessThanOrEqualTo, T greaterThan, T greaterThanOrEqualTo) {
    /**
     * Option for greater than
     */
    public RangeFilteringOptions(@Nullable T lessThan, @Nullable T lessThanOrEqualTo, @Nullable T greaterThan, @Nullable T greaterThanOrEqualTo) {
        this.lessThan = lessThan;
        this.greaterThan = greaterThan;
        this.lessThanOrEqualTo = lessThanOrEqualTo;
        this.greaterThanOrEqualTo = greaterThanOrEqualTo;
    }
}

