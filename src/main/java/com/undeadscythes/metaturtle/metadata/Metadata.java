package com.undeadscythes.metaturtle.metadata;

import com.undeadscythes.metaturtle.Metadatable;

/**
 * A single {@link Metadata} consists of a {@link Property}, a
 * {@link String value} and some {@link Metadatable} data.
 *
 * @author UndeadScythes
 */
public abstract class Metadata extends Metadatable {
    private static final long serialVersionUID = 1L;

    private final Property property;
    private String value;

    /**
     * Create a new {@link Metadata} item with a given {@link Property}
     * and value.
     */
    protected Metadata(final Property property, final String value) {
        this.property = property;
        this.value = value;
    }

    /**
     * Create a new {@link Metadata} item with a {@link Property} generated from
     * a given {@link String} and value.
     *
     * @see #Metadata(Property, String)  Metadata(Property, String)
     */
    protected Metadata(final String property, final String value) {
        this(new NamedProperty(property), value);
    }


    /**
     * Get the value of this data entity.
     */
    public String getValue() {
        return value;
    }

    /**
     * Get a {@link String} representation of the {@link Property} this
     * {@link Metadata} represents.
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Check if this {@link Metadata} represents the given {@link Property}.
     */
    public boolean isProperty(final Property property) {
        return this.property.equals(property);
    }

    /**
     * Convenience method for checking the representation {@link Property}.
     *
     * @see #isProperty(Property) isProperty(Property)
     */
    public boolean isProperty(final String string) {
        return isProperty(new NamedProperty(string));
    }

    /**
     * Change the value of this {@link Metadata}.
     *
     * @return Old value
     */
    public String setValue(final String value) {
        final String oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
