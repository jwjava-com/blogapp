/**
 * 
 */
package info.jonwarren.blog.data;

/**
 * Data enumeration of valid contact methods
 *
 * @see {@link Contact}
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public enum ContactMethod {

    MAILTO("mailto:"), HTTP("http://"), HTTPS("https://");

    /**
     * The html link method for this ContactMethod
     */
    private String method;

    private ContactMethod(String method) {
        this.method = method;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return method;
    }
}
