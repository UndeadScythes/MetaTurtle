package com.undeadscythes.udsmeta.exceptions;

import com.undeadscythes.udsmeta.MetadataKey;

/**
 * @author UndeadScythes
 */
@SuppressWarnings("serial")
public class NoMetadataSetException extends Exception {
    public MetadataKey key;

    public NoMetadataSetException(MetadataKey key) {
        super("No value set for key " + key.getString() + ".");
        this.key = key;
    }
}
