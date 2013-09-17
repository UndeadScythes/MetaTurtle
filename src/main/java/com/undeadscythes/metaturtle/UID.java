package com.undeadscythes.metaturtle;

/**
 * A unique identifier.
 *
 * @author UndeadScythes
 */
public class UID {
    private static int nextUID;

    static {
        nextUID = 1;
    }

    protected final String uid;

    /**
     * Automatically generate an ID value.
     */
    public UID() {
        uid = String.valueOf(nextUID);
        nextUID++;
    }

    /**
     * Provide a specific ID value.
     *
     * @param uid
     */
    public UID(final String uid) {
        this.uid = uid;
    }

    /**
     * An override for {@link Object#equals}.
     *
     * @param uid
     * @return True if these {@link UID}s are the same
     */
    public boolean equals(final UID uid) {
        return uid.uid.equals(this.uid);
    }
}
