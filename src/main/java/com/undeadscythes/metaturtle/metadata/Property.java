package com.undeadscythes.metaturtle.metadata;

import com.undeadscythes.metaturtle.Metadatable;

/**
 * An attribute of the {@link Metadata} of a {@link Metadatable}.
 *
 * @author UndeadScythes
 */
public abstract class Property {
    /**
     * It is advised that this method supports comparisons with
     * {@link String Strings}.
     *
     * @see Object#equals(Object)
     */
    protected abstract boolean propertyEquals(final Object obj);

    /**
     * @see Object#hashCode()
     */
    protected abstract int propertyHash();

    /**
     * @see Object#toString()
     */
    protected abstract String propertyString();

    @Override
    public String toString() {
        return propertyString();
    }

    @Override
    public boolean equals(final Object obj) {
        return propertyEquals(obj);
    }

    @Override
    public int hashCode() {
        return propertyHash();
    }
}
