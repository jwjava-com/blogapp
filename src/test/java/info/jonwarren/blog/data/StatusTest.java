/**
 * 
 */
package info.jonwarren.blog.data;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public class StatusTest {

    /**
     * Test method for {@link Status#toString()}.
     */
    //TODO: split into separate tests
    @Test
    public final void testToString() {
        Status created = Status.CREATED;
        assertThat(created.toString(), equalTo("Created"));

        Status draft = Status.DRAFT;
        assertThat(draft.toString(), equalTo("Draft"));

        Status posted = Status.POSTED;
        assertThat(posted.toString(), equalTo("Posted"));
        
        Status unposted = Status.UNPOSTED;
        assertThat(unposted.toString(), equalTo("UnPosted"));

        Status edited = Status.EDITED;
        assertThat(edited.toString(), equalTo("Edited"));

        Status deleted = Status.DELETED;
        assertThat(deleted.toString(), equalTo("Deleted"));
    }
}
