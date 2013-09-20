package com.undeadscythes.metaturtle;

import com.undeadscythes.metaturtle.exception.*;
import java.util.*;

/**
 * An entity that can accept {@link Metadata}.
 *
 * @param <T> Type of data this {@link Metadatable} will hold.
 * @author UndeadScythes
 */
public class Metadatable<T extends Object> extends ArrayList<Metadata<T>>{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to set the initial capacity of the super {@link ArrayList}.
     */
    public Metadatable(final int size) {
        super(size);
    }

    /**
     * Get a list of {@link Metadatable}s contained in the given path.
     *
     * @param path A {@link String} of the form "a.b.c", where each element is
     * the {@link Metadata#property property} of the desired sub-meta.
     */
    public List<Metadata<T>> getData(final String path) throws NoMetadataSetException {
        final List<Metadata<T>> matches = new ArrayList<Metadata<T>>(0);
        if (!path.contains(".")) return getByID(path);
        final String[] pathSplit = path.split("\\.");
        final String head = pathSplit[0];
        for (Metadata<T> data : getByID(head)) {
            try {
                matches.addAll(data.getData(path.replace(head + ".", "")));
            } catch (NoMetadataSetException ex) {}
        }
        if (matches.isEmpty()) throw new NoMetadataSetException(path);
        return matches;
    }

    private List<Metadata<T>> getByID(final String property) throws NoMetadataSetException {
        final List<Metadata<T>> matches = new ArrayList<Metadata<T>>(0);
        for (Metadata<T> data : this) {
            if (data.equals(property)) matches.add(data);
        }
        if (matches.isEmpty()) throw new NoMetadataSetException(property);
        return matches;
    }

    /**
     * Remove a {@link Metadata} with a matching property from this entity.
     */
    public void remove(final String property) {
        for (Metadata<T> data : this) {
            if (data.equals(property)) remove(data);
        }
    }
}
