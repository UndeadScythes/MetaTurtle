package com.undeadscythes.metaturtle.exceptions;

/**
 * @author UndeadScythes
 */
@SuppressWarnings("serial")
public class NotMetadatableTypeException extends Exception {
    public NotMetadatableTypeException(Class<? extends Object> clazz) {
        super("Type " + clazz.getName() + " is not a registered metadatable type.");
    }
}
