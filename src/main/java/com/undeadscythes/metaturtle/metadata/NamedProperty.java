package com.undeadscythes.metaturtle.metadata;

/**
 * A property constructed from a {@link String}.
 *
 * @author UndeadScythes
 */
public class NamedProperty extends Property {
    private final String name;

    /**
     * Build a {@link Property} using a {@link String}.
     */
    public NamedProperty(final String name) {
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
    }

    @Override
    protected boolean propertyEquals(final Object obj) {
        if (obj instanceof String) return ((String)obj).equals(name);
        if (obj instanceof Property) return ((Property)obj).toString().equals(name);
        return false;
    }

    @Override
    protected int propertyHash() {
        return 469 + name.hashCode();
    }

    @Override
    protected String propertyString() {
        return name;
    }
}
