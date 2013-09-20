package com.undeadscythes.metaturtle;

/**
 * A single {@link Metadata} consists of a {@link Property} and some
 * {@link Metadatable} data.
 *
 * @author UndeadScythes
 */
public class Metadata extends Metadatable {
    private static final long serialVersionUID = 1L;

    private final Property property;
    private String value;

    /**
     * Create a new {@link Metadata} item with a given {@link Property}
     * and value.
     */
    public Metadata(final Property property, final String value) {
        super(0);
        this.property = property;
        this.value = value;
    }

    /**
     * Create a new {@link Metadata} item with a {@link Property} generated from
     * a given {@link String} and value.
     *
     * @see #Metadata(Property, String)  Metadata(Property, String)
     */
    public Metadata(final String property, final String value) {
        this(new NamedProperty(property), value);
    }


    /**
     * Get the value of this data entity.
     */
    public String getValue() {
        return value;
    }

    /**
     * Override for {@link Object#equals} to provide a method of testing this
     * {@link Property}.
     *
     * @return True if this {@link Metadata} has the specified {@link Property}
     */
    public boolean equals(final String property) {
        return this.property.equals(property);
    }

    /**
     * Get a {@link String} representation of the {@link Property} this
     * {@link Metadata} represents.
     */
    public String getProperty() {
        return property.toString();
    }

    /**
     * Change the {@link #value value} of this {@link Metadata}.
     *
     * @return Old {@link #value value}
     */
    public String setValue(final String value) {
        final String oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
