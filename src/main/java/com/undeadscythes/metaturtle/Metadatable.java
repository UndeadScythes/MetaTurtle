package com.undeadscythes.metaturtle;

import com.undeadscythes.metaturtle.exception.NoMetadataSetException;
import com.undeadscythes.metaturtle.metadata.*;
import java.util.*;

/**
 * An entity that can accept {@link Metadata}.
 *
 * @author UndeadScythes
 */
public abstract class Metadatable extends ArrayList<Metadata>{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor to set the initial capacity of the super {@link ArrayList}.
     */
    protected Metadatable(final int size) {
        super(size);
    }

    /**
     * Default constructor sets the initial capacity of the super
     * {@link ArrayList} to zero.
     */
    protected Metadatable() {
        super(0);
    }

    /**
     * Get a list of {@link Metadata Metadatas} contained in the given path.
     *
     * @param path A {@link String} of the form "a.b.c", where each element is
     * the {@link Metadata#property property} of the desired sub-meta.
     */
    public List<Metadata> getList(final String path) throws NoMetadataSetException {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        if (!path.contains(".")) return getListFromString(path);
        final String[] pathSplit = path.split("\\.");
        final String head = pathSplit[0];
        for (Metadata data : getListFromString(head)) {
            matches.addAll(data.getList(path.replace(head + ".", "")));
        }
        return matches;
    }

    private List<Metadata> getListFromString(final String string) {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (data.isProperty(string)) {
                matches.add(data);
            }
        }
        return matches;
    }

    /**
     * Get a list of {@link Metadata Metadatas} with a given {@link Property}.
     */
    public List<Metadata> getList(final Property property) {
        final List<Metadata> matches = new ArrayList<Metadata>(0);
        for (Metadata data : this) {
            if (data.isProperty(property)) matches.add(data);
        }
        return matches;
    }

    /**
     * Get the first element of the list returned by
     * {@link #getList(String) getList(String)}.
     */
    public Metadata getFirst(final String path) throws NoMetadataSetException {
        final List<Metadata> matches = getList(path);
        if (matches.isEmpty()) throw new NoMetadataSetException(path);
        return matches.get(0);
    }

    /**
     * Get the first element of the list returned by
     * {@link #getList(Property) getList(Property)}.
     */
    public Metadata getFirst(final Property property) throws NoMetadataSetException {
        final List<Metadata> matches = getList(property);
        if (matches.isEmpty()) throw new NoMetadataSetException(property.toString());
        return matches.get(0);
    }

    /**
     * Convenience method to remove a {@link Property} with a given name.
     *
     * @see #remove(Property) remove(Property)
     */
    public Metadata remove(final String string) throws NoMetadataSetException {
        return remove(new NamedProperty(string));
    }

    /**
     * Remove a {@link Metadata} with a matching {@link Property} from this
     * entity.
     */
    public Metadata remove(final Property property) throws NoMetadataSetException {
        for(final Iterator<Metadata> i = iterator(); i.hasNext();) {
            final Metadata data = i.next();
            if (data.isProperty(property)) {
                i.remove();
                return data;
            }
        }
        throw new NoMetadataSetException(property);
    }
}
