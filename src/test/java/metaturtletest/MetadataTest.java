package metaturtletest;

import com.undeadscythes.metaturtle.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class MetadataTest {
    @Test
    public void testMetadataEquals() {
        assertTrue("equals()", new Metadata("test", "").equals("test"));
    }

    @Test
    public void testMetadataSetContent() {
        assertEquals("setContent()", "data", new Metadata("test", "data").setValue(""));
    }
}
