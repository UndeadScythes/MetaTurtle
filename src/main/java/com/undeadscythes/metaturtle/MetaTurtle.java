package com.undeadscythes.metaturtle;

import java.util.*;

/**
 * A base class that forms a container for various {@link MetaType}s of
 * {@link UniqueMeta}s. This class is also itself a {@link UniqueMeta}.
 *
 * @author UndeadScythes
 */
public abstract class MetaTurtle extends UniqueMeta<String> {
    private final Map<MetaType, Map<UID, UniqueMeta<? extends Object>>> data;

    /**
     * Set this instance as a {@link Turtle#ROOT}.
     */
    public MetaTurtle() {
        super(Turtle.ROOT);
        data = new HashMap<MetaType, Map<UID, UniqueMeta<? extends Object>>>(0);
    }

    /**
     * Add a new {@link UniqueMeta} to this container.
     *
     * @param meta
     */
    public void addMeta(final UniqueMeta<? extends Object> meta) {
        data.get(meta.getType()).put(meta.getUID(), meta);
    }
}
