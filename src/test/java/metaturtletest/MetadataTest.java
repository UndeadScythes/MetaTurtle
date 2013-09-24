package metaturtletest;

import com.undeadscythes.metaturtle.metadata.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class MetadataTest {
    @Test
    public void testMetadataEquals() {
        assertTrue(new Metadata("test", "").equals("test"));
    }

    @Test
    public void testMetadataSetContent() {
        assertEquals("data", new Metadata("test", "data").setValue(""));
    }
}
