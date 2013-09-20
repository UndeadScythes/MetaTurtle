package metaturtletest.implementation;

import com.undeadscythes.metaturtle.*;

/**
 * @author UndeadScythes
 */
public class Bestiary extends MetaTurtle<String> {
    public Bestiary() {
        addUniqueMeta(new Animal());
    }
}
