package metaturtletest;

import com.undeadscythes.metaturtle.*;
import com.undeadscythes.metaturtle.exception.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class ExceptionTest {
    @Test(expected = NoUniqueMetaException.class)
    public void testNoUniqueMetaExceptionThrow() throws NoUniqueMetaException {
        throw new NoUniqueMetaException(new UID("test"));
    }

    @Test
    public void testNoUniqueMetaExceptionMessage() {
        try {
            throw new NoUniqueMetaException(new UID("test"));
        } catch (NoUniqueMetaException ex) {
            assertTrue("getMessage()", ex.getMessage().endsWith("test."));
        }
    }

    @Test(expected = NoMetadataSetException.class)
    public void testNoMetadataSetExceptionThrow() throws NoMetadataSetException {
        throw new NoMetadataSetException("test.fail");
    }

    @Test
    public void testNoMetadataSetExceptionMessage() {
        try {
            throw new NoMetadataSetException("test.fail");
        } catch (NoMetadataSetException ex) {
            assertTrue("getMessage()", ex.getMessage().endsWith("test.fail'."));
        }
    }
}
