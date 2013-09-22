package metaturtletest;

import com.undeadscythes.metaturtle.unique.UID;
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
    public void testMetadatableGetFirstFromPath() {
        assertEquals("getFirstFromPath()", "JPEG", new Animal().getFirstFromPath("image.format").getValue());
    }

    @Test
    public void testMetadatableGetListFromPath() {
        assertEquals("getListFromPath()", "JPEG", new Animal().getListFromPath("image.format").get(0).getValue());
    }

    @Test
    public void testMetadatableGetFirst() {
        assertEquals("getFirst()", "Fred", new Animal().getFirst("name").getValue());
    }

    @Test
    public void testMetadatableGetList() {
        assertEquals("getFirst()", "Fred", new Animal().getList("name").get(0).getValue());
    }
}
