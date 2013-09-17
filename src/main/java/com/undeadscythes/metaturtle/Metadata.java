package com.undeadscythes.metaturtle;

/**
 * @param <T> Type of meta data contained
 * @author UndeadScythes
 */
public class Metadata<T extends Object> extends Metadatable<T> {
    private static final long serialVersionUID = 1L;

    private final String metaID;
    private T value;

    /**
     * Create a new data item with a given ID and value.
     *
     * @param metaID ID that should signify what the value means
     * @param value Value of the data
     */
    public Metadata(final String metaID, final T value) {
        super();
        this.metaID = metaID;
        this.value = value;
    }

    /**
     * Grab the value of this data entity.
     *
     * @return Data contained by this instance
     */
    public T getValue() {
        return value;
    }

    /**
     * Override for {@link Object#equals} to provide a method of testing this
     * {@link Metadata#metaID}.
     *
     * @param metaID
     * @return True if this {@link Metadata} has the specified metaID
     */
    public boolean equals(final String metaID) {
        return this.metaID.equals(metaID);
    }

    /**
     * Change the value of this {@link Metadata}.
     *
     * @param value New value
     * @return Old value
     */
    public T setValue(final T value) {
        final T oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
