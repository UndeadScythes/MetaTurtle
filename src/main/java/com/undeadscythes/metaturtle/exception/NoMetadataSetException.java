package com.undeadscythes.metaturtle.exception;

import com.undeadscythes.metaturtle.metadata.Metadata;
import com.undeadscythes.metaturtle.metadata.Property;

/**
 * Thrown when a request has been issued to fetch a non-existent
 * {@link Metadata} located at a given path.
 *
 * @author UndeadScythes
 */
public class NoMetadataSetException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Provide the path that caused this exception.
     */
    public NoMetadataSetException(final String path) {
        super("No Metadata has been set on the path '" + path + "'.");
    }

    /**
     * Provide the {@link Property} that caused this exception.
     */
    public NoMetadataSetException(final Property property) {
        super("No Metadata has been set with the Property '" + property.toString() + "'.");
    }
}
