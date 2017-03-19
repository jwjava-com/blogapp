/**
 * 
 */
package info.jonwarren.blog.data;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public class EntryTest {

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     */
    @Test
    public final void testSetId() {
        Entry entry = new Entry();
        entry.setId(null);
        assertThat(entry.getId(), equalTo(null));

        entry = new Entry();
        entry.setId(Long.MIN_VALUE);
        assertThat(entry.getId(), equalTo(Long.MIN_VALUE));

        entry = new Entry();
        entry.setId(Long.MAX_VALUE);
        assertThat(entry.getId(), equalTo(Long.MAX_VALUE));

        entry = new Entry();
        entry.setId(123L);
        assertThat(entry.getId(), equalTo(123L));

        Long id = new Long(345L);
        entry = new Entry();
        entry.setId(id);
        assertThat(entry.getId(), equalTo(id));
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     */
    @Test
    public final void testSetName() {
        try {
            Entry entry = new Entry();
            entry.setName("");
            assertThat(entry.getName(), equalTo(""));

            entry = new Entry();
            entry.setName("This is a test name");
            assertThat(entry.getName(), equalTo("This is a test name"));

            String name = "This is another test name";
            entry = new Entry();
            entry.setName(name);
            assertThat(entry.getName(), equalTo(name));

            entry = new Entry();
            entry.setName("12345");
            assertThat(entry.getName(), equalTo("12345"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }

        try {
            Entry entry = new Entry();
            entry.setName(null);
            assertThat(entry.getName(), equalTo(null));
        } catch (InvalidNameException e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Entry name can not be null"));
        }
    }

    /**
     * Test method for {@link Entry#setContent(java.lang.String)}.
     */
    @Test
    public final void testSetContent() {
        Entry entry = new Entry();
        entry.setContent(null);
        assertThat(entry.getContent(), equalTo(null));

        entry = new Entry();
        entry.setContent("");
        assertThat(entry.getContent(), equalTo(""));

        entry = new Entry();
        entry.setContent("This is some test content");
        assertThat(entry.getContent(), equalTo("This is some test content"));

        String name = "This is more test content";
        entry = new Entry();
        entry.setContent(name);
        assertThat(entry.getContent(), equalTo(name));

        entry = new Entry();
        entry.setContent("12345");
        assertThat(entry.getContent(), equalTo("12345"));
    }

    /**
     * Test method for {@link Entry#setStatuses(java.util.List)}.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatuses() throws InterruptedException {
        Entry entry = new Entry();
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        Thread.sleep(1L);
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));
        Thread.sleep(1L);
        statuses.add(EntryStatus.createEntryStatus(Status.DRAFT));
        Thread.sleep(1L);
        statuses.add(EntryStatus.createEntryStatus(Status.POSTED));
        entry.setStatuses(statuses);
        assertThat(entry.getStatuses(), equalTo(statuses));
    }

    /**
     * Test method for {@link Entry#setTags(java.util.Set)}.
     */
    @Test
    public final void testSetTags() {
        try {
            Entry entry = new Entry();
            Set<Tag> tags = new HashSet<Tag>();
            tags.add(Tag.createTag("test"));
            tags.add(Tag.createTag("abc"));
            tags.add(Tag.createTag("def"));
            entry.setTags(tags);
            assertThat(entry.getTags(), equalTo(tags));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling Tag.createTag");
        }
    }

    /**
     * Test method for {@link Entry#createEntry()}.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testCreateEntry() throws InterruptedException {
        try {
            Entry actual = Entry.createEntry();
            List<EntryStatus> statuses = actual.getStatuses();
            Instant createdTime = Instant.now();
            if (statuses != null && statuses.size() > 0) {
                createdTime = statuses.get(statuses.size() - 1).getTimestamp();
            }
            Thread.sleep(1L);
            Entry expected = new Entry();
            expected.setName("");
            expected.setContent("");
            expected.setStatus(Status.CREATED);
            statuses = expected.getStatuses();
            if (statuses != null && statuses.size() > 0) {
                statuses.get(statuses.size() - 1).setTimestamp(createdTime);
            }
            expected.setStatuses(statuses);
            Set<Tag> tags = new HashSet<Tag>();
            expected.setTags(tags);
            assertThat(actual, equalTo(expected));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#getCurrentStatus()}
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testGetCurrentStatus() throws InterruptedException {
        Entry entry = new Entry();
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));
        statuses.add(EntryStatus.createEntryStatus(Status.DRAFT));
        statuses.add(EntryStatus.createEntryStatus(Status.POSTED));
        entry.setStatuses(statuses);
        Thread.sleep(1L);
        EntryStatus current = entry.getCurrentStatus();
        assertThat(current.getStatus(), equalTo(Status.POSTED));

        entry = new Entry();
        statuses = new ArrayList<EntryStatus>();
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));
        entry.setStatuses(statuses);
        Thread.sleep(1L);
        current = entry.getCurrentStatus();
        assertThat(current.getStatus(), equalTo(Status.CREATED));

        entry = Entry.createEntry();
        Thread.sleep(1L);
        current = entry.getCurrentStatus();
        assertThat(current.getStatus(), equalTo(Status.CREATED));
    }

    /**
     * Test method for {@link Entry#setStatus(Status)}.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatusStatus() throws InterruptedException {
        Entry entry = new Entry();
        entry.setStatus(Status.EDITED);
        Thread.sleep(1L);
        EntryStatus current = entry.getCurrentStatus();
        assertThat(current.getStatus(), equalTo(Status.EDITED));
    }

    /**
     * Test method for {@link Entry#setStatus(EntryStatus)}.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatusEntryStatus() throws InterruptedException {
        Entry entry = new Entry();
        entry.setStatus(EntryStatus.createEntryStatus(Status.POSTED));
        Thread.sleep(1L);
        EntryStatus current = entry.getCurrentStatus();
        assertThat(current.getStatus(), equalTo(Status.POSTED));
    }

    /**
     * Test method for {@link Entry#addStatuses(java.util.List)}.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testAddStatuses() throws InterruptedException {
        Entry entry = Entry.createEntry();
        Instant createdTime = entry.getCurrentStatus().getTimestamp();
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        statuses.add(EntryStatus.createEntryStatus(Status.DRAFT));
        Instant draftTime = statuses.get(statuses.size() - 1).getTimestamp();
        statuses.add(EntryStatus.createEntryStatus(Status.POSTED));
        Instant postedTime = statuses.get(statuses.size() - 1).getTimestamp();
        entry.addStatuses(statuses);
        Thread.sleep(1L);
        List<EntryStatus> expected = new ArrayList<EntryStatus>();
        EntryStatus created = EntryStatus.createEntryStatus(Status.CREATED);
        created.setTimestamp(createdTime);
        expected.add(created);
        EntryStatus draft = EntryStatus.createEntryStatus(Status.DRAFT);
        draft.setTimestamp(draftTime);
        expected.add(draft);
        EntryStatus posted = EntryStatus.createEntryStatus(Status.POSTED);
        posted.setTimestamp(postedTime);
        expected.add(posted);
        assertThat(entry.getStatuses(), equalTo(expected));
    }

    /**
     * Test method for {@link Entry#addTags(java.util.Set)}.
     */
    @Test
    public final void testAddTags() {
        try {
            Entry entry = new Entry();
            Set<Tag> initial = new HashSet<Tag>();
            initial.add(Tag.createTag("test"));
            entry.setTags(initial);
            Set<Tag> added = new HashSet<Tag>();
            added.add(Tag.createTag("abc"));
            added.add(Tag.createTag("def"));
            entry.addTags(added);
            Set<Tag> expected = new HashSet<Tag>();
            expected.add(Tag.createTag("test"));
            expected.add(Tag.createTag("abc"));
            expected.add(Tag.createTag("def"));
            assertThat(entry.getTags(), equalTo(expected));

            entry = new Entry();
            initial = new HashSet<Tag>();
            initial.add(Tag.createTag("test"));
            initial.add(Tag.createTag("abc"));
            initial.add(Tag.createTag("def"));
            entry.setTags(initial);
            added = new HashSet<Tag>();
            added.add(Tag.createTag("abc"));
            added.add(Tag.createTag("def"));
            entry.addTags(added);
            expected = new HashSet<Tag>();
            expected.add(Tag.createTag("test"));
            expected.add(Tag.createTag("abc"));
            expected.add(Tag.createTag("def"));
            assertThat(entry.getTags(), equalTo(expected));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling Tag.createTag");
        }
    }

}
