package com.undeadscythes.udsmeta;

/**
 * @author UndeadScythes
 */
public interface MetadatableType {
    Class<? extends Object> getObjectType();
    String getID(Object obj);
}
