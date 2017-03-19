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
 * @author Jon Warren <jon@jonwarren.info>
 */
public class StatusTest {

    /**
     * Test method for {@link Status#toString()}.
     */
    @Test
    public final void testToString() {
        Status created = Status.CREATED;
        assertThat(created.toString(), equalTo("Created"));

        Status draft = Status.DRAFT;
        assertThat(draft.toString(), equalTo("Draft"));

        Status posted = Status.POSTED;
        assertThat(posted.toString(), equalTo("Posted"));

        Status edited = Status.EDITED;
        assertThat(edited.toString(), equalTo("Edited"));

        Status deleted = Status.DELETED;
        assertThat(deleted.toString(), equalTo("Deleted"));
    }
}
