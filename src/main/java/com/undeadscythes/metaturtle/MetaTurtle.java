package com.undeadscythes.metaturtle;

import com.undeadscythes.metaturtle.exception.*;
import java.util.*;

/**
 * A base class that forms a container for various {@link MetaType}s of
 * {@link UniqueMeta}s. This class is also itself a {@link UniqueMeta}.
 *
 * @author UndeadScythes
 */
public abstract class MetaTurtle extends UniqueMeta {
    private final Map<MetaType, Map<UID, UniqueMeta>> data;

    {
        data = new HashMap<MetaType, Map<UID, UniqueMeta>>(0);
    }

    /**
     * Set this instance as a {@link Turtle#ROOT ROOT} with a specific
     * {@link UID}.
     */
    public MetaTurtle(final UID uid) {
        super(Turtle.ROOT, uid);
    }

    /**
     * Set this instance as a {@link Turtle#ROOT} with an automatically
     * generated {@link UID}.
     *
     * @see #MetaTurtle(UID) MetaTurtle(UID)
     */
    public MetaTurtle() {
        this(new UID());
    }

    /**
     * Add a new {@link UniqueMeta} to this container.
     */
    public void addUniqueMeta(final UniqueMeta meta) {
        if (!data.containsKey(meta.getType())) {
            data.put(meta.getType(), new HashMap<UID, UniqueMeta>(1));
        }
        data.get(meta.getType()).put(meta.getUID(), meta);
    }

    /**
     * Get a {@link UniqueMeta} by {@link UID} created from a given
     * {@link String}.
     *
     * @see #getUniqueMeta(MetaType, UID) getUniqueMeta(MetaType, UID)
     */
    public UniqueMeta getUniqueMeta(final MetaType type, final String uid) throws NoUniqueMetaException {
        return getUniqueMeta(type, new UID(uid));
    }

    /**
     * Get a specific {@link UniqueMeta} from this {@link MetaTurtle} by
     * {@link MetaType} and {@link UID}.
     */
    public UniqueMeta getUniqueMeta(final MetaType type, final UID uid) throws NoUniqueMetaException {
        final UniqueMeta match = data.get(type).get(uid);
        if (match == null) throw new NoUniqueMetaException(uid);
        return match;
    }

    /**
     * Get a full set of {@link UniqueMeta}s of a particular {@link MetaType}.
     */
    public Collection<UniqueMeta> getUniqueMeta(final MetaType type) {
        final Collection<UniqueMeta> list = data.get(type).values();
        if (list == null) return new ArrayList<UniqueMeta>(0);
        return list;
    }
}
