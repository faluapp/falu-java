package io.falu.common;

import org.jetbrains.annotations.Nullable;

/**
 * Standard options for range filtering
 */
public class RangeFilteringOptions<T> {
    public T lessThan;

    public T lessThanOrEqualTo;

    public T greaterThan;

    public T greaterThanOrEqualTo;

    public RangeFilteringOptions(@Nullable T lessThan, @Nullable T lessThanOrEqualTo, @Nullable T greaterThan, @Nullable T greaterThanOrEqualTo) {
        this.lessThan = lessThan;
        this.greaterThan = greaterThan;
        this.lessThanOrEqualTo = lessThanOrEqualTo;
        this.greaterThanOrEqualTo = greaterThanOrEqualTo;
    }
}

