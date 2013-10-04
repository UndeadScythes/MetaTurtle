package com.undeadscythes.metaturtle.unique;

import java.util.HashSet;
import java.util.Set;

/**
 * A unique identifier.
 *
 * @author UndeadScythes
 */
public final class UID {
    private static Set<String> uids = new HashSet<String>(0);
    private static int nextUID = 1;

    private static void incrementUID() {
        nextUID++;
    }

    /**
     * The value of this {@link UID}.
     */
    private final String value;

    /**
     * Automatically generate a unique {@link #value value}.
     */
    public UID() {
        while (uids.contains(String.valueOf(nextUID))) {
            incrementUID();
        }
        value = String.valueOf(nextUID);
        uids.add(value);
    }

    /**
     * Provide a specific {@link #value value}.
     */
    public UID(final String value) {
        this.value = value;
        uids.add(value);
    }

    /**
     * Compares this {@link UID} to other {@link UID UIDs} and also to
     * {@link String Strings}.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof String) return ((String)obj).equals(value);
        if (obj instanceof UID) return ((UID)obj).toString().equals(value);
        return false;
    }

    @Override
    public int hashCode() {
        return 291 + value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * A null {@link UID} has a {@link #value value} set to "".
     */
    public boolean isNull() {
        return value.isEmpty();
    }
}
