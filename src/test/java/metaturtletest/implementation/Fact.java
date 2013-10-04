package metaturtletest.implementation;

import com.undeadscythes.metaturtle.metadata.Metadata;
import com.undeadscythes.metaturtle.metadata.Property;

/**
 * @author UndeadScythes
 */
public class Fact extends Metadata {
    private static final long serialVersionUID = 1L;

    public Fact(final String string1, final String string2) {
        super(string1, string2);
    }

    public Fact(final Property property, final String string) {
        super(property, string);
    }
}
