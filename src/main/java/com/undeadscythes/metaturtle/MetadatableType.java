package com.undeadscythes.metaturtle;

/**
 * @author UndeadScythes
 */
public interface MetadatableType {
    Class<? extends Object> getObjectType();
    String getID(Object obj);
}
