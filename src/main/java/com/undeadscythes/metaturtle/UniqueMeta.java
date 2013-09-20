package com.undeadscythes.metaturtle;

/**
 * A {@link UniqueMeta} is essentially just a {@link Metadatable} that requires
 * a {@link UID} and a {@link MetaType}. This class should be used for top level
 * hierarchical entities.
 *
 * @param <T> Type of data this {@link UniqueMeta} will hold.
 * @author UndeadScythes
 */
public abstract class UniqueMeta<T extends Object> extends Metadatable<T> {
    private final UID uid;
    private final MetaType type;

    /**
     * Specify the type and UID explicitly.
     */
    public UniqueMeta(final MetaType type, final UID uid) {
        super(0);
        this.uid = uid;
        this.type = type;
    }

    /**
     * Generate a {@link UID} automatically. This value is not guaranteed to be
     * unique.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    public UniqueMeta(final MetaType type) {
        this(type, new UID());
    }

    /**
     * Provide a {@link UID} and set the {@link MetaType} to
     * {@link Turtle#DEFAULT DEFAULT}.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    public UniqueMeta(final UID uid) {
        this(Turtle.DEFAULT, uid);
    }

    /**
     * Generate a {@link UID} from a given {@link String} and set the
     * {@link MetaType} to {@link Turtle#DEFAULT DEFAULT}.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    public UniqueMeta(final String value) {
        this(Turtle.DEFAULT, new UID(value));
    }

    /**
     * Get this {@link UniqueMeta}s {@link UID}.
     */
    public UID getUID() {
        return uid;
    }

    /**
     * Get this {@link UniqueMeta}s {@link MetaType}.
     */
    public MetaType getType() {
        return type;
    }
}
