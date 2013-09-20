package metaturtletest.implementation;

import com.undeadscythes.metaturtle.*;

/**
 * @author UndeadScythes
 */
public class Image extends Metadata<String> {
    public Image() {
        super("image", "");
        add(new Metadata<String>("format", "JPEG"));
        add(new Metadata<String>("dimensions", "200x300"));
        add(new Metadata<String>("filename", "bird.jpg"));
    }
}
