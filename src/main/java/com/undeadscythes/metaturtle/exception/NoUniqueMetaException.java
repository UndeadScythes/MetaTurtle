package com.undeadscythes.metaturtle.exception;

import com.undeadscythes.metaturtle.unique.*;

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
        super("Cannot find a unique meta with id " + uid + ".");
    }
}
