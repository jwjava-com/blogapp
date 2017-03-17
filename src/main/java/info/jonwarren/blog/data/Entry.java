/**
 * 
 */
package info.jonwarren.blog.data;

import java.util.List;

/**
 * Data container for a single blog entry.
 *
 * @author Jon Warren <jon@jonwarren.info>
 */
public class Entry {

    private Long id;
    private String name;
    private String content;
    private List<EntryStatus> status;
    private List<Tag> tags;

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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the status
     */
    public List<EntryStatus> getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(List<EntryStatus> status) {
        this.status = status;
    }

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags
     *            the tags to set
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry other = (Entry) obj;
        if (content == null) {
            if (other.content != null) {
                return false;
            }
        } else if (!content.equals(other.content)) {
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
        if (status == null) {
            if (other.status != null) {
                return false;
            }
        } else if (!status.equals(other.status)) {
            return false;
        }
        if (tags == null) {
            if (other.tags != null) {
                return false;
            }
        } else if (!tags.equals(other.tags)) {
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
        builder.append("Entry [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", content=");
        builder.append(content);
        builder.append(", status=");
        builder.append(status);
        builder.append(", tags=");
        builder.append(tags);
        builder.append("]");
        return builder.toString();
    }
}
