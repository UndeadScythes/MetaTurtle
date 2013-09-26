package com.undeadscythes.metaturtle.exception;

/**
 * Thrown when a request has been issued to fetch a
 * {@link com.undeadscythes.metaturtle.metadata.Metadata} located at a given path.
 *
 * @author UndeadScythes
 */
public class NoMetadataSetException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Provide the path at which no
     * {@link com.undeadscythes.metaturtle.metadata.Metadata} was set.
     */
    public NoMetadataSetException(final String path) {
        super("No metadata has been set on the path '" + path + "'.");
    }
}
