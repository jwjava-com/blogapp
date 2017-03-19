/**
 * 
 */
package info.jonwarren.blog.data;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test cases for setters of {@link Tag}
 *
 * @author Jon Warren <jon@jonwarren.info>
 */
public class TagTest {

    /**
     * Test method for {@link Tag#createTag(String)}
     */
    @Test
    public final void testCreateTag() {
        Tag expected = new Tag();
        try {
            expected.setName("test");
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
        expected.setCount(0L);
        Tag actual = null;
        try {
            actual = Tag.createTag("test");
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        assertThat(actual, equalTo(expected));
        
        actual = null;
        try {
            actual = Tag.createTag(null);
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Tag name can not be blank or null"));
        }
        
        actual = null;
        try {
            actual = Tag.createTag("");
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Tag name can not be blank or null"));
        }

        actual = null;
        try {
            actual = Tag.createTag("     ");
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Tag name can not be blank or null"));
        }
    }

    /**
     * Test method for {@link Tag#setId(java.lang.Long)}.
     */
    @Test
    public final void testSetId() {
        Tag tag = new Tag();
        tag.setId(null);
        assertThat(tag.getId(), equalTo(null));

        tag = new Tag();
        tag.setId(Long.MIN_VALUE);
        assertThat(tag.getId(), equalTo(Long.MIN_VALUE));

        tag = new Tag();
        tag.setId(Long.MAX_VALUE);
        assertThat(tag.getId(), equalTo(Long.MAX_VALUE));

        tag = new Tag();
        tag.setId(123L);
        assertThat(tag.getId(), equalTo(123L));

        Long id = new Long(345L);
        tag = new Tag();
        tag.setId(id);
        assertThat(tag.getId(), equalTo(id));
    }

    /**
     * Test method for {@link Tag#setName(java.lang.String)}.
     */
    @Test
    public final void testSetName() {
        try {
            Tag tag = new Tag();
            tag.setName(null);
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Tag name can not be blank or null"));
        }

        try {
            Tag tag = new Tag();
            tag.setName("");
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Tag name can not be blank or null"));
        }
        
        try {
            Tag tag = new Tag();
            tag.setName("         ");
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(InvalidNameException.class.getName()));
            assertThat(e.getMessage(), equalTo("Tag name can not be blank or null"));
        }

        try {
            Tag tag = new Tag();
            tag.setName("This is a test name");
            assertThat(tag.getName(), equalTo("This is a test name"));

            String name = "This is another test name";
            tag = new Tag();
            tag.setName(name);
            assertThat(tag.getName(), equalTo(name));

            tag = new Tag();
            tag.setName("12345");
            assertThat(tag.getName(), equalTo("12345"));
        } catch (InvalidNameException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling setName");
        }
    }

    /**
     * Test method for {@link Tag#setCount(java.lang.Long)}.
     */
    @Test
    public final void testSetCount() {
        Tag tag = new Tag();
        tag.setCount(null);
        assertThat(tag.getCount(), equalTo(0L));

        tag = new Tag();
        tag.setCount(Long.MAX_VALUE);
        assertThat(tag.getCount(), equalTo(Long.MAX_VALUE));

        tag = new Tag();
        tag.setCount(Long.MIN_VALUE);
        assertThat(tag.getCount(), equalTo(0L));

        tag = new Tag();
        tag.setCount(-1L);
        assertThat(tag.getCount(), equalTo(0L));

        tag = new Tag();
        assertThat(tag.getCount(), equalTo(0L));

        tag = new Tag();
        tag.setCount(0L);
        assertThat(tag.getCount(), equalTo(0L));

        tag = new Tag();
        tag.setCount(300L);
        assertThat(tag.getCount(), equalTo(300L));
    }

    /**
     * Test method for {@link Tag#incrementCount()}
     */
    @Test
    public final void testIncrementCount() {
        Tag tag = new Tag();
        try {
            tag.incrementCount();
        } catch (CountOverflowException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling incrementCount");
        }
        assertThat(tag.getCount(), equalTo(1L));

        try {
            tag.incrementCount();
        } catch (CountOverflowException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling incrementCount");
        }
        assertThat(tag.getCount(), equalTo(2L));

        tag = new Tag();
        tag.setCount(5000L);
        try {
            tag.incrementCount();
        } catch (CountOverflowException e) {
            e.printStackTrace();
            fail("Unexpected exception caught calling incrementCount");
        }
        assertThat(tag.getCount(), equalTo(5001L));

        tag = new Tag();
        tag.setCount(Long.MAX_VALUE);
        try {
            tag.incrementCount();
        } catch (Exception e) {
            assertThat(e.getClass().getName(), equalTo(CountOverflowException.class.getName()));
            assertThat(e.getMessage(), equalTo("Cannot incrementCount, we are at MAX_VALUE for Long"));
        }
    }
}
