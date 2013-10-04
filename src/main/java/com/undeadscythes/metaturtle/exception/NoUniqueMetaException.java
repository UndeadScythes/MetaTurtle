package com.undeadscythes.metaturtle.exception;

import com.undeadscythes.metaturtle.unique.UID;
import com.undeadscythes.metaturtle.unique.UniqueMeta;

/**
 * Thrown when a request is issued for a particular {@link UniqueMeta} but no
 * match is found.
 *
 * @author UndeadScythes
 */
public class NoUniqueMetaException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Provide the {@link UID} of the non-existent {@link UniqueMeta}.
     */
    public NoUniqueMetaException(final UID uid) {
        super("Cannot find a UniqueMeta with UID '" + uid + "'.");
    }

    /**
     * Provide the {@link UID} of the non-existent {@link UniqueMeta}.
     */
    public NoUniqueMetaException(final String uid) {
        super("Cannot find a UniqueMeta with UID '" + uid + "'.");
    }
}
