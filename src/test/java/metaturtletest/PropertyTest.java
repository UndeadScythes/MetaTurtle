package metaturtletest;

import com.undeadscythes.metaturtle.metadata.NamedProperty;
import metaturtletest.implementation.Taxonomy.Level;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author UndeadScythes
 */
public class PropertyTest {
    @Test
    public void testPropertyEquals() {
        assertTrue(Level.GENUS.getTaxonomy().equals(Level.GENUS.getTaxonomy()));
        assertTrue(Level.GENUS.getTaxonomy().equals(Level.GENUS));
        assertTrue(Level.GENUS.getTaxonomy().equals("Genus"));
    }

    @Test
    public void testPropertyToString() {
        assertEquals("Genus", Level.GENUS.getTaxonomy().toString());
    }

    @Test
    public void testNamedPropertyToString() {
        assertEquals("Test", new NamedProperty("Test").toString());
    }

    @Test
    public void testNamedPropertyEquals() {
        assertTrue(new NamedProperty("Test").equals("Test"));
        assertEquals(new NamedProperty("Test"), new NamedProperty("Test"));
    }
}
