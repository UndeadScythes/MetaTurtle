package com.undeadscythes.metaturtle.metadata;

/**
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

    public boolean equals(final String string) {
        return name.equals(string);
    }

    public String getString() {
        return name;
    }
}
