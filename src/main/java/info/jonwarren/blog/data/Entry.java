/**
 * 
 */
package info.jonwarren.blog.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;

import info.jonwarren.blog.exceptions.InvalidNameException;

/**
 * Data container for a single blog entry.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entry_id")
    private Long id;

    @NotNull
    @Column(name = "entry_name")
    private String name;

    @Column(name = "entry_content")
    private String content;

    @Column(name = "short_url")
    private String shortUrl;

    @OneToMany
    @JoinColumn(name = "status_id")
    private List<EntryStatus> statuses;

    @OneToMany
    @JoinColumn(name = "tag_id")
    private Set<Tag> tags;

    //TODO: add JPA annotations
    //TODO: create tests
    private Copyright copyright;

    /**
     * Create a new {@link Entry} object, initialized to default values.
     */
    public static Entry createEntry() {
        Entry entry = new Entry();

        entry.name = "";
        entry.content = "";
        entry.setStatus(Status.CREATED);
        entry.tags = new HashSet<Tag>();

        return entry;
    }

    /**
     * Gets the current {@link EntryStatus} value.
     * 
     * @return the current {@link EntryStatus}, or null if {@link #statuses} is null or empty
     */
    public EntryStatus getCurrentStatus() {
        if (CollectionUtils.isEmpty(this.statuses)) {
            return null;
        }

        return this.statuses.get(this.statuses.size() - 1);
    }

    /**
     * Sets the {@link Entry} to be of {@link Status} status.
     * 
     * @param status
     *            the {@link Status} to set
     */
    public void setStatus(Status status) {
        setStatus(EntryStatus.createEntryStatus(status));
    }

    /**
     * Sets the {@link Entry} to be of {@link EntryStatus} status.
     * 
     * @param status
     *            the {@link EntryStatus} to set
     */
    public void setStatus(EntryStatus status) {
        List<EntryStatus> statuses = new ArrayList<EntryStatus>();
        statuses.add(status);
        addStatuses(statuses);
    }

    /**
     * Add all {@link EntryStatus} values to statuses
     * 
     * @param statuses
     *            the statuses to add
     */
    public void addStatuses(List<EntryStatus> statuses) {
        if (this.statuses == null) {
            this.statuses = new ArrayList<EntryStatus>(statuses.size());
        }

        if (CollectionUtils.isNotEmpty(statuses)) {
            this.statuses.addAll(statuses);
        }
    }

    /**
     * Add the provided {@link Tag} to {@link #tags}
     * 
     * @param tag
     *            the tag to add
     */
    public void addTag(Tag tag) {
        if (this.tags == null) {
            this.tags = new HashSet<Tag>(tags.size());
        }
        this.tags.add(tag);
    }

    /**
     * Add all {@link Tag} values to {@link #tags}
     * 
     * @param tags
     *            the tags to add
     */
    public void addTags(Set<Tag> tags) {
        if (this.tags == null) {
            this.tags = new HashSet<Tag>(tags.size());
        }

        if (CollectionUtils.isNotEmpty(tags)) {
            this.tags.addAll(tags);
        }
    }

    // REMINDER: Do not delete & re-auto-generate all Getters & Setters -- some are tweaked to throw exceptions
    // TODO: is this even good practice??? Probably not, so maybe we should change how this is handled.
    // REMINDER: hashCode, equals, and toString are safe to be re-auto-generated

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
    //TODO: restrict to not negative
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    //TODO: html decode values
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     * @throws InvalidNameException
     *             if provided name is null
     */
    //TODO: html encode values
    public void setName(String name) throws InvalidNameException {
        if (name == null) {
            throw new InvalidNameException("Entry name can not be null");
        }
        this.name = name;
    }

    /**
     * @return the content
     */
    //TODO: html decode values
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    //TODO: html encode values
    //TODO: strip some html tags
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the shortUrl
     */
    //TODO: html decode values
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * @param shortUrl
     *            the shortUrl to set
     */
    //TODO: if shortUrl == null; change current status to 'unposted'
    //TODO: spaces should not be allowed
    //TODO: html encode values
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     * @return the statuses
     */
    public List<EntryStatus> getStatuses() {
        return statuses;
    }

    /**
     * @param statuses
     *            the statuses to set
     */
    //TODO: prevent setting to an empty list, or null
    public void setStatuses(List<EntryStatus> statuses) {
        this.statuses = statuses;
    }

    /**
     * @return the tags
     */
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags
     *            the tags to set
     */
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @return the copyright
     */
    public Copyright getCopyright() {
        return copyright;
    }

    /**
     * @param copyright
     *            the copyright to set
     */
    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
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
        result = prime * result + ((copyright == null) ? 0 : copyright.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((shortUrl == null) ? 0 : shortUrl.hashCode());
        result = prime * result + ((statuses == null) ? 0 : statuses.hashCode());
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
        if (copyright == null) {
            if (other.copyright != null) {
                return false;
            }
        } else if (!copyright.equals(other.copyright)) {
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
        if (shortUrl == null) {
            if (other.shortUrl != null) {
                return false;
            }
        } else if (!shortUrl.equals(other.shortUrl)) {
            return false;
        }
        if (statuses == null) {
            if (other.statuses != null) {
                return false;
            }
        } else if (!statuses.equals(other.statuses)) {
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
        builder.append(", shortUrl=");
        builder.append(shortUrl);
        builder.append(", statuses=");
        builder.append(statuses);
        builder.append(", tags=");
        builder.append(tags);
        builder.append(", copyright=");
        builder.append(copyright);
        builder.append("]");
        return builder.toString();
    }
}
