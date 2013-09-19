package com.undeadscythes.metaturtle;

/**
 * {@link Turtle} is an implementation of {@link MetaType} that provides a
 * {@link Turtle#ROOT} element.
 *
 * @author UndeadScythes
 */
public class Turtle implements MetaType {
    /**
     * Root element to define a {@link MetaTurtle}.
     */
    public static final Turtle ROOT;

    /**
     * For use when no other {@link MetaType} is given.
     */
    public static final Turtle DEFAULT;

    static {
        ROOT = new Turtle();
        DEFAULT = new Turtle();
    }

    private Turtle() {}
}
