package metaturtletest;

import com.undeadscythes.metaturtle.*;
import com.undeadscythes.metaturtle.exception.*;
import metaturtletest.implementation.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class MetadatableTest {
    @Test
    public void testUniqueMetaGetUID() {
        assertTrue("getUID()", new Animal().getUID().equals("7"));
    }

    @Test
    public void testUniqueMetaGetType() {
        assertEquals("getType()", AnimalType.BIRD, new Animal().getType());
    }

    @Test
    public void testUIDIsNull() {
        assertTrue("isNull()", new UID("").isNull());
    }

    @Test
    public void testUIDEquals() {
        assertTrue("equals()", new UID("test").equals(new UID("test")));
    }

    @Test
    public void testUIDImplicitToString() {
        assertEquals("toString()", "test", new UID("test") + "");
    }

    @Test
    public void testMetadatableGetData() {
        try {
            assertEquals("getData()", "JPEG", (new Animal().getData("image.format").get(0).getValue()));
        } catch (NoMetadataSetException ex) {
            fail("getData()");
        }
    }

    @Test
    public void testMetadatableGetByID() {
        try {
            assertEquals("getByID()", "Fred", (new Animal().getData("name").get(0).getValue()));
        } catch (NoMetadataSetException ex) {
            fail("getByID()");
        }
    }
}
