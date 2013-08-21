package com.undeadscythes.udsmeta;

import com.undeadscythes.udsmeta.exceptions.NoMetadataSetException;
import com.undeadscythes.udsmeta.exceptions.NotMetadatableTypeException;
import java.util.*;
import java.util.logging.*;

/**
 * @author UndeadScythes
 */
public class MetaUtils<M extends Object> {
    private M meta;

    public MetaUtils(final M meta) throws NotMetadatableTypeException {
        MetaCore.getType(meta.getClass());
        this.meta = meta;
    }

    public M getMeta() {
        return meta;
    }

    public boolean getBool(final MetadataKey key) {
        try {
            return (Boolean)MetaCore.get(meta, key);
        } catch (NoMetadataSetException ex) {
            return false;
        }
    }

    public int getInt(final MetadataKey key) throws NoMetadataSetException {
        return (Integer)MetaCore.get(meta, key);
    }

    public String getString(final MetadataKey key) throws NoMetadataSetException {
        return (String)MetaCore.get(meta, key);
    }

    public  long getLong(final MetadataKey key) throws NoMetadataSetException {
        return (Long)MetaCore.get(meta, key);
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> List<T> getList(final MetadataKey key, List<T> list) throws NoMetadataSetException {
        list.addAll((List<T>)MetaCore.get(meta, key));
        return list;
    }

    public  UUID getUUID(final MetadataKey key) throws NoMetadataSetException {
        return (UUID)MetaCore.get(meta, key);
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> T[] getArray(final MetadataKey key, T[] array) throws NoMetadataSetException {
        return (T[])MetaCore.get(meta, key);
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> Set<T> getSet(final MetadataKey key, Set<T> set) throws NoMetadataSetException {
        return (Set<T>)MetaCore.get(meta, key);
    }

    public Object get(final MetadataKey key) throws NoMetadataSetException {
        return MetaCore.get(meta, key);
    }

    public Object pop(final MetadataKey key) throws NoMetadataSetException {
        try {
            return MetaCore.pop(meta, key);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(MetaUtils.class.getName()).severe(ex.getMessage() + " Metadata not popped.");
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(MetaCore.class.getName()).severe(trace.toString());
            }
        }
        throw new NoMetadataSetException(key);
    }

    public boolean exists(final MetadataKey key) {
        return MetaCore.exists(meta, key);
    }

    public void set(MetadataKey key, final Object value) {
        try {
            MetaCore.set(meta, key, value);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(MetaUtils.class.getName()).severe(ex.getMessage() + " Metadata not set.");
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(MetaCore.class.getName()).severe(trace.toString());
            }
        }
    }

    public boolean remove(final MetadataKey key) {
        try {
            return MetaCore.remove(meta, key);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(MetaUtils.class.getName()).severe(ex.getMessage() + " Metadata not removed.");
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(MetaCore.class.getName()).severe(trace.toString());
            }
            return false;
        }
    }
}
