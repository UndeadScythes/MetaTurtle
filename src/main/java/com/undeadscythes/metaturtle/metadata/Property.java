package com.undeadscythes.metaturtle.metadata;

/**
 * An attribute of the {@link Metadata} of a
 * {@link com.undeadscythes.metaturtle.Metadatable}.
 *
 * @author UndeadScythes
 */
public interface Property {
    /**
     * Check if this {@link Property} is equal to a given {@link String}.
     */
    boolean equals(final String string);

    /**
     * Check if this {@link Property} is equal to a given {@link Property}.
     */
    boolean equals(final Property property);

    /**
     * Get a {@link String} form of this {@link Property}.
     */
    String getString();
}
