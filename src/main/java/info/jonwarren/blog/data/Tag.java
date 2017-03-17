/**
 * 
 */
package info.jonwarren.blog.data;

/**
 * Data container for tags that are assignable to entries.
 * 
 * @see {@link Entry}
 * @author Jon Warren <jon@jonwarren.info>
 */
public class Tag {

    private Long id;
    private String name;
    private Long count;

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
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the count
     */
    public Long getCount() {
        return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(Long count) {
        this.count = count;
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
