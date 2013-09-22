package metaturtletest;

import com.undeadscythes.metaturtle.exception.*;
import com.undeadscythes.metaturtle.unique.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class ExceptionTest {
    private static final NoUniqueMetaException UNIQUE = new NoUniqueMetaException(new UID("test"));
    private static final NoMetadataSetException METADATA = new NoMetadataSetException("test.fail");

    @Test(expected = NoUniqueMetaException.class)
    public void testNoUniqueMetaExceptionThrow() throws NoUniqueMetaException {
        throw UNIQUE;
    }

    @Test
    public void testNoUniqueMetaExceptionMessage() {
        try {
            throw UNIQUE;
        } catch (NoUniqueMetaException ex) {
            assertTrue("getMessage()", ex.getMessage().endsWith("test."));
        }
    }

    @Test(expected = NoMetadataSetException.class)
    public void testNoMetadataSetExceptionThrow() throws NoMetadataSetException {
        throw METADATA;
    }

    @Test
    public void testNoMetadataSetExceptionMessage() {
        try {
            throw METADATA;
        } catch (NoMetadataSetException ex) {
            assertTrue("getMessage()", ex.getMessage().endsWith("test.fail'."));
        }
    }
}
