package com.undeadscythes.metaturtle.unique;

import com.undeadscythes.metaturtle.Metadatable;
import com.undeadscythes.metaturtle.Turtle;

/**
 * A {@link UniqueMeta} is essentially just a {@link Metadatable} that requires
 * a {@link UID} and a {@link MetaType}. This class should be used for top level
 * hierarchical entities.
 *
 * @author UndeadScythes
 */
public abstract class UniqueMeta extends Metadatable {
    private final UID uid;
    private final MetaType type;

    /**
     * Specify the type and UID explicitly.
     */
    protected UniqueMeta(final MetaType type, final UID uid) {
        this.uid = uid;
        this.type = type;
    }

    /**
     * Generate a {@link UID} automatically.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    protected UniqueMeta(final MetaType type) {
        this(type, new UID());
    }

    /**
     * Generate a {@link UID} from the given {@link String}.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    protected UniqueMeta(final MetaType type, final String string) {
        this(type, new UID(string));
    }

    /**
     * Provide a {@link UID} and set the {@link MetaType} to
     * {@link Turtle#DEFAULT DEFAULT}.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    protected UniqueMeta(final UID uid) {
        this(Turtle.DEFAULT, uid);
    }

    /**
     * Generate a {@link UID} from a given {@link String} and set the
     * {@link MetaType} to {@link Turtle#DEFAULT DEFAULT}.
     *
     * @see UniqueMeta#UniqueMeta(MetaType, UID) UniqueMeta(MetaType, UID)
     */
    protected UniqueMeta(final String value) {
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
