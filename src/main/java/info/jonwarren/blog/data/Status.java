/**
 * 
 */
package info.jonwarren.blog.data;

/**
 * Data enumeration of valid statuses assignable to entries
 *
 * @see {@link Entry}
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public enum Status {
    /**
     * The entry was created
     */
    CREATED("Created"),

    /**
     * The entry is an unpublished draft
     */
    DRAFT("Draft"),

    /**
     * The entry has been made available for display / is published
     */
    POSTED("Posted"),

    /**
     * The entry was edited
     */
    EDITED("Edited"),

    /**
     * The entry has been removed from display / is no longer published
     */
    UNPOSTED("UnPosted"),

    /**
     * The entry has been deleted / removed from display
     */
    DELETED("Deleted");

    /**
     * The user-facing name for this Status.
     */
    private String name;

    /**
     * Prevent creating these outside of this enum
     * 
     * @param name
     *            String to use for the name in calls to toString()
     */
    private Status(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
