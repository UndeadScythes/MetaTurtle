package com.undeadscythes.metaturtle;

/**
 * An attribute of the {@link Metadata} of a {@link Metadatable}.
 *
 * @author UndeadScythes
 */
public interface Property {
    /**
     * Check if this {@link Property} is equals to a given {@link String}.
     */
    boolean equals(final String string);

    /**
     * Get a {@link String} form of this {@link Property}.
     */
    String getString();
}
