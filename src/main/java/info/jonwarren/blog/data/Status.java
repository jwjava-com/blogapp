/**
 * 
 */
package info.jonwarren.blog.data;

/**
 * Data enumeration of valid statuses assignable to entries
 *
 * @see {@link Entry}
 * @author Jon Warren <jon@jonwarren.info>
 */
public enum Status {
    CREATED("Created"), POSTED("Posted"), EDITED("Edited"), DELETED("Deleted");

    private String name;

    Status(String name) {
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
