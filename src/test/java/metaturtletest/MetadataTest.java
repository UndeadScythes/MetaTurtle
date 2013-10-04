package metaturtletest;

import com.undeadscythes.metaturtle.metadata.NamedProperty;
import metaturtletest.implementation.Fact;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author UndeadScythes
 */
public class MetadataTest {
    @Test
    public void testMetadataEquals() {
        assertTrue(new Fact("test", "").isProperty("test"));
        assertTrue(new Fact("test", "").isProperty(new NamedProperty("test")));
    }

    @Test
    public void testMetadataSetContent() {
        assertEquals("data", new Fact("test", "data").setValue(""));
    }

    @Test
    public void testMetadataGetters() {
        assertEquals("data", new Fact("test", "data").getValue());
        assertTrue(new Fact("test", "data").getProperty().equals("test"));
        assertEquals(new NamedProperty("test"), new Fact("test", "data").getProperty());
    }
}
