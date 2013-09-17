package com.undeadscythes.metaturtle;

import java.util.*;

/**
 * An entity that can accept metadata.
 *
 * @param <T> Type of meta data contained
 *
 * @author UndeadScythes
 */
public class Metadatable<T extends Object> extends ArrayList<Metadata<T>>{
    private static final long serialVersionUID = 1L;

    /**
     * Get a list of metadata contained in the given path. Paths are strings of
     * the form "top.sublevel.tail", where each element is the
     * {@link Metadata#metaID} of the desired element.
     *
     * @param path
     * @return List of matching {@link Metadata}
     */
    public List<Metadata<T>> getData(final String path) {
        final List<Metadata<T>> matches = new ArrayList<Metadata<T>>(0);
        final String[] pathSplit = path.split(".");
        final String head = pathSplit[0];
        for (Metadata<T> data : getByID(head)) {
            if (pathSplit.length > 1) {
                matches.addAll(data.getData(path.replace(head + ".", "")));
            }
        }
        return matches;
    }

    /**
     * Select this {@link Metadatable}s {@link Metadata} elements with a
     * matching {@link Metadata#metaID}.
     *
     * @param metaID
     * @return List of matching {@link Metadata}
     */
    public List<Metadata<T>> getByID(final String metaID) {
        final List<Metadata<T>> matches = new ArrayList<Metadata<T>>(0);
        for (Metadata<T> data : this) {
            if (data.equals(metaID)) matches.add(data);
        }
        return matches;
    }
}
