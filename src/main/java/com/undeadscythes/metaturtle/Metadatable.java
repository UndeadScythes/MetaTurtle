package com.undeadscythes.metaturtle;

import com.undeadscythes.metaturtle.exception.*;
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
     * Get a list of {@link Metadatable}s contained in the given path.
     *
     * @param path A {@link String} of the form "a.b.c", where each element is
     * the {@link Metadata#metaID metaID} of the desired sub-meta.
     */
    public List<Metadatable> getData(final String path) throws NoMetadataSetException {
        final List<Metadatable> matches = new ArrayList<Metadatable>(0);
        if (!path.contains(".")) return getByID(path);
        final String[] pathSplit = path.split("\\.");
        final String head = pathSplit[0];
        for (Metadatable data : getByID(head)) {
            try {
                matches.addAll(data.getData(path.replace(head + ".", "")));
            } catch (NoMetadataSetException ex) {}
        }
        if (matches.isEmpty()) throw new NoMetadataSetException(path);
        return matches;
    }

    private List<Metadatable> getByID(final String metaID) throws NoMetadataSetException {
        final List<Metadatable> matches = new ArrayList<Metadatable>(0);
        for (Metadata data : this) {
            if (data.equals(metaID)) matches.add(data.getValue());
        }
        if (matches.isEmpty()) throw new NoMetadataSetException(metaID);
        return matches;
    }
}
