package metaturtletest.implementation;

import com.undeadscythes.metaturtle.*;

/**
 * @author UndeadScythes
 */
public class Animal extends UniqueMeta {
    public Animal() {
        super(AnimalType.BIRD, new UID("7"));
        add(new Image());
        add(new Metadata("name", "Fred"));
        add(new Metadata("color", "green"));
    }
}
