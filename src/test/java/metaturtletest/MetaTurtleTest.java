package metaturtletest;

import com.undeadscythes.metaturtle.exception.NoUniqueMetaException;
import com.undeadscythes.metaturtle.unique.UID;
import metaturtletest.implementation.AnimalType;
import metaturtletest.implementation.Bestiary;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author UndeadScythes
 */
public class MetaTurtleTest {
    @Test
    public void testMetaTurtleGetByType() {
        assertEquals(1, new Bestiary().getUniqueMeta(AnimalType.BIRD).size());
    }

    @Test
    public void testMetaTurtleGetByTypeAndString() {
        try {
            assertEquals(AnimalType.BIRD, new Bestiary().getUniqueMeta(AnimalType.BIRD, "7").getType());
        } catch (NoUniqueMetaException ex) {
            fail();
        }
    }

    @Test
    public void testMetaTurtleGetByTypeAndUID() {
        try {
            assertEquals(AnimalType.BIRD, new Bestiary().getUniqueMeta(AnimalType.BIRD, new UID("7")).getType());
        } catch (NoUniqueMetaException ex) {
            fail();
        }
    }

    @Test
    public void testMetaTurtleGetAll() {
        assertEquals(1, new Bestiary().getUniqueMeta().size());
    }

    @Test
    public void testMetaTurtleGetMap() {
        assertEquals(1, new Bestiary().getMap(AnimalType.BIRD).size());
    }
}
