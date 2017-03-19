/**
 * 
 */
package info.jonwarren.blog.data;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.Instant;

import org.junit.Test;

import info.jonwarren.blog.utils.TimestampHelpers;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public class EntryStatusTest {

    /**
     * Test method for
     * {@link EntryStatus#createEntryStatus(Status)}.
     */
    @Test
    public final void testCreateEntryStatus() {
        EntryStatus actual = EntryStatus.createEntryStatus(Status.CREATED);
        assertThat(actual.getStatus(), equalTo(Status.CREATED));

        actual = EntryStatus.createEntryStatus(Status.DELETED);
        assertThat(actual.getStatus(), equalTo(Status.DELETED));
    }

    /**
     * Test method for {@link EntryStatus#setId(java.lang.Long)}.
     */
    @Test
    public final void testSetId() {
        EntryStatus status = new EntryStatus();
        status.setId(null);
        assertThat(status.getId(), equalTo(null));

        status = new EntryStatus();
        status.setId(Long.MIN_VALUE);
        assertThat(status.getId(), equalTo(Long.MIN_VALUE));

        status = new EntryStatus();
        status.setId(Long.MAX_VALUE);
        assertThat(status.getId(), equalTo(Long.MAX_VALUE));

        status = new EntryStatus();
        status.setId(123L);
        assertThat(status.getId(), equalTo(123L));

        Long id = new Long(345L);
        status = new EntryStatus();
        status.setId(id);
        assertThat(status.getId(), equalTo(id));
    }

    /**
     * Test method for
     * {@link EntryStatus#setStatus(Status)}.
     */
    @Test
    public final void testSetStatus() {
        EntryStatus status = new EntryStatus();
        status.setStatus(Status.CREATED);
        assertThat(status.getStatus(), equalTo(Status.CREATED));

        status = new EntryStatus();
        status.setStatus(Status.DELETED);
        assertThat(status.getStatus(), equalTo(Status.DELETED));
    }

    /**
     * Test method for {@link EntryStatus#setTimestamp(java.time.Instant)}.
     */
    @Test
    public final void testSetTimestamp() {
        EntryStatus status = new EntryStatus();
        Instant now = Instant.now();
        status.setTimestamp(now);
        assertThat(status.getTimestamp(), equalTo(now));

        status = new EntryStatus();
        status.setTimestamp(null);
        boolean isClose = TimestampHelpers.timestampsClose(status.getTimestamp(), Instant.now());
        assertThat(isClose, equalTo(true));

        status = new EntryStatus();
        status.setTimestamp(Instant.EPOCH);
        isClose = TimestampHelpers.timestampsClose(status.getTimestamp(), Instant.now());
        assertThat(isClose, equalTo(true));

        status = new EntryStatus();
        status.setTimestamp(Instant.MIN);
        isClose = TimestampHelpers.timestampsClose(status.getTimestamp(), Instant.now());
        assertThat(isClose, equalTo(true));

        status = new EntryStatus();
        status.setTimestamp(Instant.MAX);
        isClose = TimestampHelpers.timestampsClose(status.getTimestamp(), Instant.now());
        assertThat(isClose, equalTo(true));
    }

}
