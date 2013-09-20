package metaturtletest.implementation;

import com.undeadscythes.metaturtle.*;

/**
 * @author UndeadScythes
 */
public class Animal extends UniqueMeta<String> {
    public Animal() {
        super(AnimalType.BIRD, new UID("7"));
        add(new Image());
        add(new Metadata<String>("name", "Fred"));
        add(new Metadata<String>("color", "green"));
    }
}
