package com.undeadscythes.metaturtle.unique;

/**
 * A unique identifier, the term unique being used in its loosest sense.
 *
 * @author UndeadScythes
 */
public class UID {
    private static int nextUID = 1;

    /**
     * The {@link String} value of this {@link UID}.
     */
    protected final String value;

    /**
     * Automatically generate a {@link #value value}.
     */
    public UID() {
        value = String.valueOf(nextUID);
        nextUID++;
    }

    /**
     * Provide a specific {@link #value value}.
     */
    public UID(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof UID && ((UID)obj).value.equals(value);
    }

    @Override
    public int hashCode() {
        return 291 + (value == null ? 0 : value.hashCode());
    }

    /**
     * An override for {@link Object#equals}.
     *
     * @return True if these {@link UID}s {@link #value value}s are the same
     */
    public boolean equals(final UID uid) {
        return uid.value.equals(value);
    }

    /**
     * An override for {@link Object#equals}.
     *
     * @return True if the {@link #value value} of the {@link UID} generated by
     * the given {@link String} and the {@link #value value} of this {@link UID}
     * match.
     */
    public boolean equals(final String value) {
        return value.equals(this.value);
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