package com.undeadscythes.metaturtle;

/**
 * A single {@link Metadata} consists of a {@link Property} and some
 * {@link Metadatable} data.
 *
 * @param <T> Type of data this {@link Metadata} will hold.
 * @author UndeadScythes
 */
public class Metadata<T extends Object> extends Metadatable<T> {
    private static final long serialVersionUID = 1L;

    private final Property property;
    private T value;

    /**
     * Create a new {@link Metadata} item with a given {@link Property}
     * and value.
     */
    public Metadata(final Property property, final T value) {
        super(0);
        this.property = property;
        this.value = value;
    }

    /**
     * Create a new {@link Metadata} item with a {@link Property} generated from
     * a given {@link String} and value.
     *
     * @see #Metadata(Property, Object)  Metadata(Property, T)
     */
    public Metadata(final String property, final T value) {
        this(new NamedProperty(property), value);
    }


    /**
     * Get the value of this data entity.
     */
    public T getValue() {
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
    public T setValue(final T value) {
        final T oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
