package com.undeadscythes.metaturtle;

/**
 * A {@link UniqueMeta} is essentially just a {@link Metadata} that requires a
 * unique identifier and a {@link MetaType}. This class should be used for top
 * level hierarchical records.
 *
 * @param <T> Type of meta data contained
 *
 * @author UndeadScythes
 */
public abstract class UniqueMeta<T extends Object> extends Metadatable<T> {
    private final UID uid;
    private final MetaType type;

    /**
     * Generate a {@link UID} automatically. This value is not guaranteed to be
     * unique.
     *
     * @param type Type of this instance
     */
    public UniqueMeta(final MetaType type) {
        super();
        uid = new UID();
        this.type = type;
    }

    /**
     * @return {@link UID} of this instance
     */
    public UID getUID() {
        return uid;
    }

    /**
     * @return {@link MetaType} of this instance
     */
    public MetaType getType() {
        return type;
    }

    /**
     * Add data into this classes metadata hierarchy.
     *
     * @param data
     */
    public void addData(final Metadata<T> data) {
        add(data);
    }
}
