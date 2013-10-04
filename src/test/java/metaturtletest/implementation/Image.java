package metaturtletest.implementation;

import com.undeadscythes.metaturtle.metadata.Metadata;

/**
 * @author UndeadScythes
 */
@SuppressWarnings("serial")
public class Image extends Metadata {
    public Image() {
        super("image", "");
        add(new Fact("format", "JPEG"));
        add(new Fact("dimensions", "200x300"));
        add(new Fact("filename", "bird.jpg"));
    }
}
