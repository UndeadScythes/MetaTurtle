package metaturtletest;

import com.undeadscythes.metaturtle.unique.UID;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author UndeadScythes
 */
public class UIDTest {
    @Test
    public void testUIDEquals() {
        assertEquals(new UID("test"), new UID("test"));
        assertEquals(new UID("test"), "test");
    }

    public void testUIDAuto() {
        assertEquals(Integer.parseInt(new UID().toString()) + 1, Integer.parseInt(new UID().toString()));
        final List<UID> uids = new ArrayList<UID>(100);
        for (int i = 0; i < 1000; i++) {
            uids.add(new UID());
            for (int j = 0; j < i; j++) {
                assertNotEquals(uids.get(i), uids.get(j));
            }
        }
    }

    @Test
    public void testUIDNull() {
        assertTrue(new UID("").isNull());
    }

    @Test
    public void testUIDImplicitToString() {
        assertEquals("test", new UID("test") + "");
    }
}
