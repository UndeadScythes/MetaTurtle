package metaturtletest;

import com.undeadscythes.metaturtle.*;
import com.undeadscythes.metaturtle.exception.*;
import metaturtletest.implementation.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class MetaTurtleTest {
    @Test
    public void testMetaTurtleGetByType() {
        assertEquals("getUniqueMeta(MetaType)", 1, new Bestiary().getUniqueMeta(AnimalType.BIRD).size());
    }

    @Test
    public void testMetaTurtleGetByTypeAndString() {
        try {
            assertEquals("getUniqueMeta(MetaType, String)", AnimalType.BIRD, new Bestiary().getUniqueMeta(AnimalType.BIRD, "7").getType());
        } catch (NoUniqueMetaException ex) {
            fail("getUniqueMeta(MetaType, String)");
        }
    }

    @Test
    public void testMetaTurtleGetByTypeAndUID() {
        try {
            assertEquals("getUniqueMeta(MetaType, UID)", AnimalType.BIRD, new Bestiary().getUniqueMeta(AnimalType.BIRD, new UID("7")).getType());
        } catch (NoUniqueMetaException ex) {
            fail("getUniqueMeta(MetaType, UID)");
        }
    }
}
