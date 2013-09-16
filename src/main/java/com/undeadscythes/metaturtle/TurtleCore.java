package com.undeadscythes.metaturtle;

import com.undeadscythes.jaml.*;
import com.undeadscythes.jaml.exceptions.*;
import com.undeadscythes.metaturtle.exceptions.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 * @author UndeadScythes
 */
public class TurtleCore {
    private static YamlTree yaml;
    private static HashMap<String, MetadataKey> keys;
    private static HashMap<Class<? extends Object>, MetadatableType> types;
    private static HashMap<MetadatableType, HashMap<String, HashMap<MetadataKey, Object>>> store;

    private static void loadKeys(final MetadataKey[] keyList) {
        keys = new HashMap<String, MetadataKey>(keyList.length);
        for(MetadataKey key : keyList) {
            keys.put(key.getString(), key);
        }
    }

    private static void loadTypes(final MetadatableType[] typeList) {
        types = new HashMap<Class<? extends Object>, MetadatableType>(typeList.length);
        for(MetadatableType type : typeList) {
            types.put(type.getObjectType(), type);
        }
        store = new HashMap<MetadatableType, HashMap<String, HashMap<MetadataKey, Object>>>(types.size());
    }

    protected static MetadatableType getType(Class<? extends Object> clazz) throws NotMetadatableTypeException {
        for(Map.Entry<Class<? extends Object>, MetadatableType> entry : types.entrySet()) {
            if(entry.getKey().isAssignableFrom(clazz)) return entry.getValue();
        }
        throw new NotMetadatableTypeException(clazz);
    }

    public static Object get(final Object obj, final MetadataKey key) throws NoMetadataSetException {
        if(obj == null || !exists(obj, key)) throw new NoMetadataSetException(key);
        try {
            MetadatableType type = getType(obj.getClass());
            return store.get(type).get(type.getID(obj)).get(key);
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(TurtleCore.class.getName()).severe(ex.getMessage());
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(TurtleCore.class.getName()).severe(trace.toString());
            }
            throw new NoMetadataSetException(key);
        }
    }

    public static Object pop(final Object meta, final MetadataKey key) throws NoMetadataSetException, NotMetadatableTypeException {
        Object obj = get(meta, key);
        remove(meta, key);
        return obj;
    }

    public static boolean exists(final Object obj, final MetadataKey key) {
        try {
            MetadatableType type = getType(obj.getClass());
            Object meta = type.getObjectType().cast(obj);
            HashMap<String, HashMap<MetadataKey, Object>> typeStore = store.get(type);
            if(!typeStore.containsKey(type.getID(meta)) || !typeStore.get(type.getID(meta)).containsKey(key)) return false;
            return true;
        } catch (NotMetadatableTypeException ex) {
            Logger.getLogger(TurtleCore.class.getName()).severe(ex.getMessage());
            for(StackTraceElement trace : ex.getStackTrace()) {
                Logger.getLogger(TurtleCore.class.getName()).severe(trace.toString());
            }
            return false;
        }
    }

    public static void set(final Object obj, final MetadataKey key, final Object value) throws NotMetadatableTypeException {
        MetadatableType type = getType(obj.getClass());
        Object meta = type.getObjectType().cast(obj);
        HashMap<String, HashMap<MetadataKey, Object>> typeStore = store.get(type);
        if(typeStore == null) throw new NotMetadatableTypeException(meta.getClass());
        if(!typeStore.containsKey(type.getID(obj))) {
            typeStore.put(type.getID(obj), new HashMap<MetadataKey, Object>(0));
        }
        HashMap<MetadataKey, Object> metadata = typeStore.get(type.getID(obj));
        metadata.put(key, value);
    }

    public static boolean remove(final Object obj, final MetadataKey key) throws NotMetadatableTypeException {
        MetadatableType type = getType(obj.getClass());
        HashMap<MetadataKey, Object> keyMap = store.get(type).get(type.getID(obj));
        if(keyMap != null) {
            keyMap.remove(key);
            return true;
        } else {
            return false;
        }
    }

    public static void loadMeta(final String path, final MetadatableType[] typeList, final MetadataKey[] keyList) throws IOException {
        yaml = new YamlTree(path);
        yaml.load();
        loadTypes(typeList);
        loadKeys(keyList);
        for(MetadatableType type : types.values()) {
            store.put(type, new HashMap<String, HashMap<MetadataKey, Object>>(0));
        }
    }

    public static void save() throws IOException {
        yaml.reset();
        for(MetadatableType type : types.values()) {
            for(Map.Entry<String, HashMap<MetadataKey, Object>> entry : store.get(type).entrySet()) {
                for(Map.Entry<MetadataKey, Object> metadata : entry.getValue().entrySet()) {
                    if(!metadata.getKey().isPersistent()) continue;
                    yaml.set(type.toString() + "." + entry.getKey().concat("." + metadata.getKey().getString()), metadata.getValue());
                }
            }
        }
        yaml.save();
    }

    public static boolean isEmpty() {
        return yaml.isEmpty();
    }

    public static void attach(final Object obj) throws IOException, NotMetadatableTypeException {
        MetadatableType type = getType(obj.getClass());
        Object meta = type.getObjectType().cast(obj);
        try {
            for(Map.Entry<String, Object> entry : yaml.getValues(type.toString() + "." + type.getID(obj)).entrySet()) {
                set(meta, keys.get(entry.getKey()), entry.getValue());
            }
        } catch (NoSuchYamlPathException ex) {}
    }

    private TurtleCore() {}
}
