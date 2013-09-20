package metaturtletest.implementation;

import com.undeadscythes.metaturtle.*;

/**
 * @author UndeadScythes
 */
public class Image extends Metadata {
    public Image() {
        super("image", "");
        add(new Metadata("format", "JPEG"));
        add(new Metadata("dimensions", "200x300"));
        add(new Metadata("filename", "bird.jpg"));
    }
}
