package com.github.hexagonoframework.core;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public abstract class ValueObject<T> {

    private final T value;

    public ValueObject(final T value) {
        requireNonNull(value);
        this.value = value;
    }

    public final T value() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        ValueObject<?> other = (ValueObject<?>) obj;
        return Objects.equals(this.value, other.value);
    }
}
