package com.undeadscythes.udsmeta;

/**
 * @author UndeadScythes
 */
public class NamedKey implements MetadataKey {
    private String name;
    private boolean persistent;

    public NamedKey(MetadataKey key, String name) {
        this.name = key.getString() + "." + name;
        this.persistent = key.isPersistent();
    }

    @Override
    public boolean isPersistent() {
        return persistent;
    }

    @Override
    public String getString() {
        return name;
    }
}
