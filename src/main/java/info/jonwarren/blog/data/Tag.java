/**
 * 
 */
package info.jonwarren.blog.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

/**
 * Data container for tags that are assignable to entries.
 * 
 * @see {@link Entry}
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private Long id;

    @NotNull
    @Column(name = "tag_name")
    private String name;

    @NotNull
    @Column(name = "tag_usage_cnt")
    private Long count = 0L;

    /**
     * Public static method for creating a {@link Tag} with {@link #name} set to the provided value.
     * 
     * @param name
     *            the name to set
     * @return the {@link Tag} object
     * @throws InvalidNameException
     *             if provided name is blank or null
     * @see {@link StringUtils#isBlank(String)}
     */
    public static Tag createTag(String name) throws InvalidNameException {
        if (StringUtils.isBlank(name)) {
            throw new InvalidNameException("Tag name can not be blank or null");
        }

        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }

    /**
     * Increment the {@link #count} value by 1.
     * 
     * @throws CountOverflowException
     *             if {@link #count} is already at {@link Long#MAX_VALUE}
     */
    public void incrementCount() throws CountOverflowException {
        if (this.count == Long.MAX_VALUE) {
            throw new CountOverflowException("Cannot incrementCount, we are at MAX_VALUE for Long");
        }

        this.count++;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     * @throws InvalidNameException
     *             if provided name is blank or null
     * @see {@link StringUtils#isBlank(String)}
     */
    public void setName(String name) throws InvalidNameException {
        if (StringUtils.isBlank(name)) {
            throw new InvalidNameException("Tag name can not be blank or null");
        }

        this.name = name;
    }

    /**
     * @return the count
     */
    public Long getCount() {
        return count;
    }

    /**
     * Sets the {@link #count} to the provided value, unless a negative value was specified, then sets the
     * {@link #count} to zero.
     * 
     * @param count
     *            the count to set
     */
    public void setCount(Long count) {
        if (count == null || count < 0L) {
            this.count = 0L;
        } else {
            this.count = count;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((count == null) ? 0 : count.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) obj;
        if (count == null) {
            if (other.count != null) {
                return false;
            }
        } else if (!count.equals(other.count)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tag [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", count=");
        builder.append(count);
        builder.append("]");
        return builder.toString();
    }
}
