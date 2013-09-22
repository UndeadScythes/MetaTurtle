package metaturtletest.implementation;

import com.undeadscythes.metaturtle.metadata.*;
import com.undeadscythes.metaturtle.unique.*;

/**
 * @author UndeadScythes
 */
@SuppressWarnings("serial")
public class Animal extends UniqueMeta {
    public Animal() {
        super(AnimalType.BIRD, new UID("7"));
        add(new Image());
        add(new Metadata("name", "Fred"));
        add(new Metadata("color", "green"));
    }
}
