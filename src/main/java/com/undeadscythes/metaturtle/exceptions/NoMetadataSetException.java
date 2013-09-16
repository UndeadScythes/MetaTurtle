package com.undeadscythes.metaturtle.exceptions;

import com.undeadscythes.metaturtle.MetadataKey;

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
