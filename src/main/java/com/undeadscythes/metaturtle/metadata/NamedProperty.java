package com.undeadscythes.metaturtle.metadata;

/**
 * A property constructed from a {@link String}.
 *
 * @author UndeadScythes
 */
public class NamedProperty implements Property {
    private final String name;

    /**
     * Build a {@link Property} using a {@link String}.
     */
    public NamedProperty(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final String string) {
        return name.equals(string);
    }

    @Override
    public boolean equals(final Property property) {
        return name.equals(property.getString());
    }

    @Override
    public String getString() {
        return name;
    }
}
