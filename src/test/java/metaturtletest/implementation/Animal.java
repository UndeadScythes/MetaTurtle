package metaturtletest.implementation;

import com.undeadscythes.metaturtle.unique.UID;
import com.undeadscythes.metaturtle.unique.UniqueMeta;
import metaturtletest.implementation.Taxonomy.Level;

/**
 * @author UndeadScythes
 */
@SuppressWarnings("serial")
public class Animal extends UniqueMeta {
    public Animal() {
        super(AnimalType.BIRD, new UID("7"));
        add(new Image());
        add(new Fact("name", "Fred"));
        add(new Fact("color", "green"));
        add(new Fact(Level.SPECIES.getTaxonomy(), "Flappity"));
    }
}
