package io.falu.common;

import java.util.Map;
import java.util.Objects;

public final class Optional<T> {
    private final boolean hasValue;
    private final T value;

    private Optional(T value) {
        this.hasValue = true;
        this.value = value;
    }

    private Optional(Optional<T> other) {
        this.hasValue = other != null && other.hasValue;
        this.value = (other != null) ? other.value : null;
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
    }

    public static <T> Optional<T> empty() {
        return new Optional<>(null);
    }

    public static <T> Optional<T> from(T value) {
        return new Optional<>(value);
    }

    public boolean hasValue() {
        return hasValue;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return hasValue ? Objects.toString(value) : "unspecified";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Optional<?> optional = (Optional<?>) obj;
        return hasValue == optional.hasValue && Objects.equals(value, optional.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasValue, value);
    }
}
