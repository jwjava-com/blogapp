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

import info.jonwarren.blog.exceptions.InvalidNameException;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public class EntryTest {

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling nulls.
     */
    @Test
    public final void testSetId() {
        Entry entry = new Entry();
        entry.setId(null);
        assertThat(entry.getId(), equalTo(null));
    }

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling {@link Long#MIN_VALUE}
     */
    @Test
    public final void testSetIdToMinValue() {
        Entry entry = new Entry();
        entry.setId(Long.MIN_VALUE);
        assertThat(entry.getId(), equalTo(Long.MIN_VALUE));
    }

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling {@link Long#MIN_VALUE}
     */
    @Test
    public final void testSetIdToMaxValue() {
        Entry entry = new Entry();
        entry.setId(Long.MAX_VALUE);
        assertThat(entry.getId(), equalTo(Long.MAX_VALUE));
    }

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling positive values from hardcoded values.
     */
    @Test
    public final void testSetIdToPositiveHardcoded() {
        Entry entry = new Entry();
        entry.setId(123L);
        assertThat(entry.getId(), equalTo(123L));
    }

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling positive values from a variable.
     */
    @Test
    public final void testSetIdToPositiveFromVariable() {
        Long id = new Long(345L);
        Entry entry = new Entry();
        entry.setId(id);
        assertThat(entry.getId(), equalTo(id));
    }

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling negative values from hardcoded values.
     */
    @Test
    public final void testSetIdToNegativeHardcoded() {
        Entry entry = new Entry();
        entry.setId(-456L);
        assertThat(entry.getId(), equalTo(-456L));
    }

    /**
     * Test method for {@link Entry#setId(java.lang.Long)}.
     * <p>
     * Tests handling negative values from a variable.
     */
    @Test
    public final void testSetIdToNegativeFromVariable() {
        Long id = new Long(-789L);
        Entry entry = new Entry();
        entry.setId(id);
        assertThat(entry.getId(), equalTo(id));
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling empty strings.
     */
    @Test
    public final void testSetNameToEmptyString() {
        try {
            Entry entry = new Entry();
            entry.setName("");
            assertThat(entry.getName(), equalTo(""));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling setting to string without spaces.
     */
    @Test
    public final void testSetNameToStringWithoutSpaces() {
        try {
            Entry entry = new Entry();
            entry.setName("Test");
            assertThat(entry.getName(), equalTo("Test"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling setting to string with spaces from a hardcoded value.
     */
    @Test
    public final void testSetNameToStringWithSpacesHardcoded() {
        try {
            Entry entry = new Entry();
            entry.setName("This is a test name");
            assertThat(entry.getName(), equalTo("This is a test name"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling setting to string with spaces from a variable.
     */
    @Test
    public final void testSetNameToStringWithSpacesFromVariable() {
        try {
            String name = "This is another test name";
            Entry entry = new Entry();
            entry.setName(name);
            assertThat(entry.getName(), equalTo(name));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling setting to a string of only numeric digits.
     */
    @Test
    public final void testSetNameToNumbersOnly() {
        try {
            Entry entry = new Entry();
            entry.setName("12345");
            assertThat(entry.getName(), equalTo("12345"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling setting to string without spaces.
     */
    @Test
    public final void testSetNameToStringWithSymbols() {
        try {
            Entry entry = new Entry();
            entry.setName("This, this name, shouldn't break -- it has symbols; just symbols.");
            assertThat(entry.getName(),
                    equalTo("This, this name, shouldn't break -- it has symbols; just symbols."));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling nulls.
     */
    @Test
    public final void testSetNameToNull() {
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
     * <p>
     * Tests handling nulls.
     */
    @Test
    public final void testSetContentToNull() {
        Entry entry = new Entry();
        entry.setContent(null);
        assertThat(entry.getContent(), equalTo(null));
    }

    /**
     * Test method for {@link Entry#setContent(java.lang.String)}.
     * <p>
     * Tests handling empty strings.
     */
    @Test
    public final void testSetContentToEmptyString() {
        Entry entry = new Entry();
        entry.setContent("");
        assertThat(entry.getContent(), equalTo(""));
    }

    /**
     * Test method for {@link Entry#setName(java.lang.String)}.
     * <p>
     * Tests handling setting to string without spaces.
     */
    @Test
    public final void testSetContentToStringWithoutSpaces() {
        Entry entry = new Entry();
        entry.setContent("Test");
        assertThat(entry.getContent(), equalTo("Test"));
    }

    /**
     * Test method for {@link Entry#setContent(java.lang.String)}.
     * <p>
     * Tests handling setting to string with spaces from a hardcoded value.
     */
    @Test
    public final void testSetContentToStringWithSpacesHardcoded() {
        Entry entry = new Entry();
        entry.setContent("This is some test content");
        assertThat(entry.getContent(), equalTo("This is some test content"));
    }

    /**
     * Test method for {@link Entry#setContent(java.lang.String)}.
     * <p>
     * Tests handling setting to string with spaces from a variable.
     */
    @Test
    public final void testSetContentToStringWithSpacesFromVariable() {
        String name = "This is more test content";
        Entry entry = new Entry();
        entry.setContent(name);
        assertThat(entry.getContent(), equalTo(name));
    }

    /**
     * Test method for {@link Entry#setContent(java.lang.String)}.
     * <p>
     * Tests handling setting to a string of only numeric digits.
     */
    @Test
    public final void testSetContentToNumbersOnly() {
        Entry entry = new Entry();
        entry.setContent("12345");
        assertThat(entry.getContent(), equalTo("12345"));
    }

    /**
     * Test method for {@link Entry#setShortUrl(java.lang.String)}.
     * <p>
     * Tests handling 
     */
    @Test
    public final void testSetShortUrlTo() {
        Entry entry = new Entry();
        entry.setShortUrl(null);
        assertThat(entry.getShortUrl(), equalTo(null));
    }

    /**
     * Test method for {@link Entry#setShortUrl(java.lang.String)}.
     * <p>
     * Tests handling empty strings.
     */
    @Test
    public final void testSetShortUrlToEmptyString() {
        Entry entry = new Entry();
        entry.setShortUrl("");
        assertThat(entry.getShortUrl(), equalTo(""));
    }

    /**
     * Test method for {@link Entry#setShortUrl(java.lang.String)}.
     * <p>
     * Tests handling setting to string with spaces from a hardcoded value.
     */
    @Test
    public final void testSetShortUrlToStringWithSpacesHardcoded() {
        //TODO: spaces should not be allowed
        Entry entry = new Entry();
        entry.setShortUrl("This is some test content");
        assertThat(entry.getShortUrl(), equalTo("This is some test content"));
    }

    /**
     * Test method for {@link Entry#setShortUrl(java.lang.String)}.
     * <p>
     * Tests handling setting to string with spaces from a variable.
     */
    @Test
    public final void testSetShortUrlToStringWithSpacesFromVariable() {
        String name = "This is more test content";
        Entry entry = new Entry();
        entry.setShortUrl(name);
        assertThat(entry.getShortUrl(), equalTo(name));
    }

    /**
     * Test method for {@link Entry#setShortUrl(java.lang.String)}.
     * <p>
     * Tests handling setting to a string of only numeric digits.
     */
    @Test
    public final void testSetShortUrlToNumbersOnly() {
        Entry entry = new Entry();
        entry.setShortUrl("12345");
        assertThat(entry.getShortUrl(), equalTo("12345"));
    }

    /**
     * Test method for {@link Entry#setStatuses(java.util.List)}.
     * <p>
     * Tests handling setting to a list of multiple values.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatusesToMultipleValues() throws InterruptedException {
        Entry entry = new Entry();
        
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        
        Thread.sleep(1L); // Forces creation milliseconds to be consistently different
        
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));
        
        Thread.sleep(1L); // Forces creation milliseconds to be consistently different
        
        statuses.add(EntryStatus.createEntryStatus(Status.DRAFT));
        
        Thread.sleep(1L); // Forces creation milliseconds to be consistently different
        
        statuses.add(EntryStatus.createEntryStatus(Status.POSTED));
        
        entry.setStatuses(statuses);
        
        assertThat(entry.getStatuses(), equalTo(statuses));
    }
    
    /**
     * Test method for {@link Entry#setStatuses(java.util.List)}.
     * <p>
     * Tests handling setting to a list of only a single value.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatusesToSingleValue() throws InterruptedException {
        Entry entry = new Entry();
        
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        
        Thread.sleep(1L); // Forces creation milliseconds to be consistently different
        
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));

        entry.setStatuses(statuses);
        
        assertThat(entry.getStatuses(), equalTo(statuses));
    }

    /**
     * Test method for {@link Entry#setStatuses(java.util.List)}.
     * <p>
     * Tests handling setting to an empty list.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatusesToEmptyList() throws InterruptedException {
        Entry entry = new Entry();
        
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        
        entry.setStatuses(statuses);
        
        assertThat(entry.getStatuses(), equalTo(statuses));
    }
    
    /**
     * Test method for {@link Entry#setStatuses(java.util.List)}.
     * <p>
     * Tests handling nulls.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testSetStatusesToNull() throws InterruptedException {
        Entry entry = new Entry();
        
        List<EntryStatus> statuses = null;
        
        entry.setStatuses(statuses);
        
        assertThat(entry.getStatuses(), equalTo(statuses));
    }
    
    /**
     * Test method for {@link Entry#setTags(java.util.Set)}.
     * <p>
     * Tests handling setting to a set of multiple values.
     */
    @Test
    public final void testSetTagsToMultipleValues() {
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
     * Test method for {@link Entry#setTags(java.util.Set)}.
     * <p>
     * Tests handling setting to a set of only a single value.
     */
    @Test
    public final void testSetTagsToSingleValue() {
        try {
            Entry entry = new Entry();
            
            Set<Tag> tags = new HashSet<Tag>();
            tags.add(Tag.createTag("test"));
            entry.setTags(tags);
            
            assertThat(entry.getTags(), equalTo(tags));
            
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling Tag.createTag");
        }
    }
    
    /**
     * Test method for {@link Entry#setTags(java.util.Set)}.
     * <p>
     * Tests handling setting to an empty set.
     */
    @Test
    public final void testSetTagsToEmptySet() {
        Entry entry = new Entry();
        
        Set<Tag> tags = new HashSet<Tag>();
        entry.setTags(tags);
        
        assertThat(entry.getTags(), equalTo(tags));
    }
    
    /**
     * Test method for {@link Entry#setTags(java.util.Set)}.
     * <p>
     * Tests handling nulls.
     */
    @Test
    public final void testSetTagsToNull() {
        Entry entry = new Entry();
        
        Set<Tag> tags = null;
        entry.setTags(tags);
        
        assertThat(entry.getTags(), equalTo(tags));
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

            Thread.sleep(1L); // Forces creation milliseconds to be consistently different

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
     * <p>
     * Tests handling lists of multiple values.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testGetCurrentStatusWithMultipleStatuses() throws InterruptedException {
        Entry entry = new Entry();

        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));
        statuses.add(EntryStatus.createEntryStatus(Status.DRAFT));
        statuses.add(EntryStatus.createEntryStatus(Status.POSTED));
        entry.setStatuses(statuses);

        Thread.sleep(1L); // Forces creation milliseconds to be consistently different

        EntryStatus current = entry.getCurrentStatus();

        assertThat(current.getStatus(), equalTo(Status.POSTED));
    }

    /**
     * Test method for {@link Entry#getCurrentStatus()}
     * <p>
     * Tests handling list of only a single value.
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testGetCurrentStatusWithOnlyOneStatus() throws InterruptedException {
        Entry entry = new Entry();

        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        statuses.add(EntryStatus.createEntryStatus(Status.CREATED));
        entry.setStatuses(statuses);

        Thread.sleep(1L); // Forces creation milliseconds to be consistently different

        EntryStatus current = entry.getCurrentStatus();

        assertThat(current.getStatus(), equalTo(Status.CREATED));
    }

    /**
     * Test method for {@link Entry#getCurrentStatus()}
     * <p>
     * Tests handling newly created entry (default status).
     * 
     * @throws InterruptedException
     */
    @Test
    public final void testGetCurrentStatusWithDefaultStatus() throws InterruptedException {
        Entry entry = Entry.createEntry();

        Thread.sleep(1L); // Forces creation milliseconds to be consistently different

        EntryStatus current = entry.getCurrentStatus();

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
     * <p>
     * Tests handling adding tags to existing tags.
     */
    @Test
    public final void testAddTagsToExisting() {
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

        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling Tag.createTag");
        }
    }

    /**
     * Test method for {@link Entry#addTags(java.util.Set)}.
     * <p>
     * Tests handling adding tags that contain duplicates of existing tags.
     */
    @Test
    public final void testAddTagsToExistingWithDuplicates() {
        try {
            Entry entry = new Entry();

            Set<Tag> initial = new HashSet<Tag>();
            initial.add(Tag.createTag("test"));
            initial.add(Tag.createTag("abc"));
            initial.add(Tag.createTag("def"));
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

        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling Tag.createTag");
        }
    }
}
