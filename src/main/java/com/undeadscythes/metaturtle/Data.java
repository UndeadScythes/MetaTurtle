package com.undeadscythes.metaturtle;

/**
 * A single piece of information.
 *
 * @author UndeadScythes
 */
public class Data extends Metadatable {
    private static final long serialVersionUID = 1L;

    private String content;

    /**
     * Create a {@link Data} that consists of a single {@link String}.
     */
    public Data(final String content) {
        super(0);
        this.content = content;
    }

    /**
     * Get the {@link #content content} of this {@link Data}.
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the {@link #content content} of this {@link Data}.
     *
     * @return Old {@link #content content}
     */
    public String setContent(final String content) {
        final String oldContent = this.content;
        this.content = content;
        return oldContent;
    }
}
