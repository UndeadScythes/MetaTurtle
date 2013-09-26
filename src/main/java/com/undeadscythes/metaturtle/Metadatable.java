package com.undeadscythes.metaturtle;

import com.undeadscythes.metaturtle.exception.*;
import com.undeadscythes.metaturtle.metadata.*;
import java.util.*;

/**
 * An entity that can accept {@link Metadata}.
 *
 * @author UndeadScythes
 */
public class Metadatable extends ArrayList<Metadata>{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to set the initial capacity of the super {@link ArrayList}.
     */
    public Metadatable(final int size) {
        super(size);
    }

    /**
     * Default constructor sets the initial capacity of the super
     * {@link ArrayList} to zero.
     */
    public Metadatable() {
        super(0);
    }

    /**
     * Get a list of {@link Metadata}s contained in the given path.
     *
     * @param path A {@link String} of the form "a.b.c", where each element is
     * the {@link Metadata#property property} of the desired sub-meta.
     */
    public List<Metadata> getListFromPath(final String path) throws NoMetadataSetException {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        if (!path.contains(".")) return getList(path);
        final String[] pathSplit = path.split("\\.");
        final String head = pathSplit[0];
        for (Metadata data : getList(head)) {
            matches.addAll(data.getList(path.replace(head + ".", "")));
        }
        return matches;
    }

    /**
     * Get a list of {@link Metadata}s with a {@link Property} equal to the
     * given {@link String}.
     */
    public List<Metadata> getList(final String string) {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (data.equals(string)) {
                matches.add(data);
            }
        }
        return matches;
    }

    /**
     * Get a list of {@link Metadata}s with a given {@link Property}.
     */
    public List<Metadata> getList(final Property property) {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (data.equals(property)) matches.add(data);
        }
        return matches;
    }

    /**
     * Get the first element of the list returned by
     * {@link #getListFromPath(String) getListFromPath(String)}.
     */
    public Metadata getFirstFromPath(final String path) throws NoMetadataSetException {
        final List<Metadata> matches = getListFromPath(path);
        if (matches.isEmpty()) throw new NoMetadataSetException(path);
        return matches.get(0);
    }

    /**
     * Get the first element of the list returned by
     * {@link #getList(String) getList(String)}.
     */
    public Metadata getFirst(final String string) throws NoMetadataSetException {
        final List<Metadata> matches = getList(string);
        if (matches.isEmpty()) throw new NoMetadataSetException(string);
        return matches.get(0);
    }

    /**
     * Get the first element of the list returned by
     * {@link #getList(Property) getList(Property)}.
     */
    public Metadata getFirst(final Property property) throws NoMetadataSetException {
        final List<Metadata> matches = getList(property);
        if (matches.isEmpty()) throw new NoMetadataSetException(property.getString());
        return matches.get(0);
    }

    /**
     * Remove a {@link Metadata} with a matching property from this entity.
     */
    public Metadata remove(final String property) throws NoMetadataSetException {
        for(final Iterator<Metadata> i = iterator(); i.hasNext();) {
            final Metadata data = i.next();
            if (data.equals(property)) {
                i.remove();
                return data;
            }
        }
        throw new NoMetadataSetException(property);
    }
}
