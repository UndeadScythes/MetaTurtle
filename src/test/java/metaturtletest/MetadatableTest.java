package metaturtletest;

import com.undeadscythes.metaturtle.exception.NoMetadataSetException;
import metaturtletest.implementation.Animal;
import metaturtletest.implementation.AnimalType;
import metaturtletest.implementation.Taxonomy.Level;
import static org.junit.Assert.*;
import org.junit.Test;

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
    public void testMetadatableGetFirstPath() throws NoMetadataSetException {
        assertEquals("JPEG", new Animal().getFirst("image.format").getValue());
    }

    @Test
    public void testMetadatableGetListPath() throws NoMetadataSetException {
        assertEquals("JPEG", new Animal().getList("image.format").get(0).getValue());
    }

    @Test
    public void testMetadatableGetFirst() throws NoMetadataSetException {
        System.out.println(new Animal().getFirst("name").getValue());
        assertEquals("Fred", new Animal().getFirst("name").getValue());
    }

    @Test
    public void testMetadatableGetList() throws NoMetadataSetException {
        assertEquals("Fred", new Animal().getList("name").get(0).getValue());
    }

    @Test
    public void testMetadatableGetFirstProperty() throws NoMetadataSetException {
        assertEquals("Flappity", new Animal().getFirst(Level.SPECIES.getTaxonomy()).getValue());
    }

    @Test
    public void testMetadatableGetListProperty() throws NoMetadataSetException {
        assertEquals("Flappity", new Animal().getList(Level.SPECIES.getTaxonomy()).get(0).getValue());
    }

    @Test(expected = NoMetadataSetException.class)
    public void testMetadatableGetFail() throws NoMetadataSetException {
        new Animal().getFirst("fail").getValue();
    }

    @Test(expected = NoMetadataSetException.class)
    public void testMetadatableRemove() throws NoMetadataSetException {
        final Animal animal = new Animal();
        assertEquals("Fred", animal.remove("name").getValue());
        animal.getFirst("name");
    }

    @Test(expected = NoMetadataSetException.class)
    public void testMetadatableRemoveProperty() throws NoMetadataSetException {
        final Animal animal = new Animal();
        assertEquals("Flappity", animal.remove(Level.SPECIES.getTaxonomy()).getValue());
        animal.getFirst(Level.SPECIES.getTaxonomy());
    }
}
