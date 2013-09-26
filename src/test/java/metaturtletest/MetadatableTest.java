package metaturtletest;

import com.undeadscythes.metaturtle.exception.*;
import com.undeadscythes.metaturtle.unique.*;
import metaturtletest.implementation.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class MetadatableTest {
    @Test
    public void testUniqueMetaGetUID() {
        assertTrue(new Animal().getUID().equals("7"));
    }

    @Test
    public void testUniqueMetaGetType() {
        assertEquals(AnimalType.BIRD, new Animal().getType());
    }

    @Test
    public void testUIDIsNull() {
        assertTrue(new UID("").isNull());
    }

    @Test
    public void testUIDEquals() {
        assertTrue(new UID("test").equals(new UID("test")));
    }

    @Test
    public void testUIDImplicitToString() {
        assertEquals("test", new UID("test") + "");
    }

    @Test
    public void testMetadatableGetFirstFromPath() throws NoMetadataSetException {
        assertEquals("JPEG", new Animal().getFirstFromPath("image.format").getValue());
    }

    @Test
    public void testMetadatableGetListFromPath() throws NoMetadataSetException {
        assertEquals("JPEG", new Animal().getListFromPath("image.format").get(0).getValue());
    }

    @Test
    public void testMetadatableGetFirst() throws NoMetadataSetException {
        assertEquals("Fred", new Animal().getFirst("name").getValue());
    }

    @Test
    public void testMetadatableGetList() {
        assertEquals("Fred", new Animal().getList("name").get(0).getValue());
    }
}
