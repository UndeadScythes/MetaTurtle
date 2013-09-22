package metaturtletest.implementation;

import com.undeadscythes.metaturtle.*;
import java.io.*;

/**
 * @author UndeadScythes
 */
@SuppressWarnings("serial")
public class Bestiary extends MetaTurtle {
    public Bestiary() {
        addUniqueMeta(new Animal());
    }

    @Override
    public void load(String path) throws IOException {}

    @Override
    public void save() {}
}
