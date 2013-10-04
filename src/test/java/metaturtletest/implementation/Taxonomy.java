package metaturtletest.implementation;

import com.undeadscythes.metaturtle.metadata.Property;
import org.apache.commons.lang3.StringUtils;

/**
 * @author UndeadScythes
 */
public class Taxonomy extends Property {
    public static enum Level {
        LIFE,
        DOMAIN,
        KINGDOM,
        PHYLUM,
        CLASS,
        ORDER,
        FAMILY,
        GENUS,
        SPECIES;

        public Taxonomy getTaxonomy() {
            return new Taxonomy(this);
        }
    }

    private final Level level;

    private Taxonomy(final Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    protected boolean propertyEquals(final Object obj) {
        if (obj instanceof Taxonomy) return ((Taxonomy)obj).getLevel().equals(level);
        if (obj instanceof Level) return ((Level)obj).equals(level);
        if (obj instanceof String) return ((String)obj).equals(toString());
        return false;
    }

    @Override
    protected int propertyHash() {
        return 157 + level.hashCode();
    }

    @Override
    protected String propertyString() {
        return StringUtils.capitalize(level.name().toLowerCase());
    }
}
