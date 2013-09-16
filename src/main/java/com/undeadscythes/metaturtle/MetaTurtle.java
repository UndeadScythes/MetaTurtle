package com.undeadscythes.metaturtle;

import com.undeadscythes.metaturtle.exceptions.*;
import java.util.*;
import java.util.logging.*;

/**
 * @param <M>
 * @author UndeadScythes
 */
public class MetaTurtle<M extends Object> {
    private M meta;

    public MetaTurtle(final M meta) throws NotMetadatableTypeException {
        TurtleCore.getType(meta.getClass());
        this.meta = meta;
    }

    public M getMeta() {
        return meta;
    }

    public boolean getBool(final MetadataKey key) {
        try {
            return (Boolean)TurtleCore.get(meta, key);
        } catch (NoMetadataSetException ex) {
            return false;
        }
    }

    public int getInt(final MetadataKey key) throws NoMetadataSetException {
        return (Integer)TurtleCore.get(meta, key);
    }

    public String getString(final MetadataKey key) throws NoMetadataSetException {
        return (String)TurtleCore.get(meta, key);
    }

    public  long getLong(final MetadataKey key) throws NoMetadataSetException {
        return (Long)((Number)TurtleCore.get(meta, key)).longValue();
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> List<T> getList(final MetadataKey key, List<T> list) throws NoMetadataSetException {
        list.addAll((List<T>)TurtleCore.get(meta, key));
        return list;
    }

    public  UUID getUUID(final MetadataKey key) throws NoMetadataSetException {
        return (UUID)TurtleCore.get(meta, key);
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> T[] getArray(final MetadataKey key, T[] array) throws NoMetadataSetException {
        return (T[])TurtleCore.get(meta, key);
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> Set<T> getSet(final MetadataKey key, Set<T> set) throws NoMetadataSetException {
        return (Set<T>)TurtleCore.get(meta, key);
    }

    public Object get(final MetadataKey key) throws NoMetadataSetException {
        return TurtleCore.get(meta, key);
    }

    public Object pop(final MetadataKey key) throws NoMetadataSetException {
        try {
            return TurtleCore.pop(meta, key);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(MetaTurtle.class.getName()).severe(ex.getMessage() + " Metadata not popped.");
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(TurtleCore.class.getName()).severe(trace.toString());
            }
        }
        throw new NoMetadataSetException(key);
    }

    public boolean exists(final MetadataKey key) {
        return TurtleCore.exists(meta, key);
    }

    public void set(MetadataKey key, final Object value) {
        try {
            TurtleCore.set(meta, key, value);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(MetaTurtle.class.getName()).severe(ex.getMessage() + " Metadata not set.");
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(TurtleCore.class.getName()).severe(trace.toString());
            }
        }
    }

    public boolean remove(final MetadataKey key) {
        try {
            return TurtleCore.remove(meta, key);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(MetaTurtle.class.getName()).severe(ex.getMessage() + " Metadata not removed.");
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(TurtleCore.class.getName()).severe(trace.toString());
            }
            return false;
        }
    }
}
