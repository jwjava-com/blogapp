/**
 * 
 */
package info.jonwarren.blog.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Data container for a single blog area.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
//TODO: create tests
@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "area_id")
    private Long id;

    @NotNull
    @Column(name = "area_name")
    private String name;

    @Column(name = "short_url")
    private String shortUrl;

    @OneToMany
    @JoinColumn(name = "entry_id")
    private List<Entry> entries;

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
     * @return the shortUrl
     */
    public String getShortUrl() {
        return shortUrl;
    }

    /**
     * @param shortUrl
     *            the shortUrl to set
     */
    //TODO: if shortUrl == null; change current status to 'unposted'
    //TODO: spaces should not be allowed
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    /**
     * @return the entries
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * @param entries
     *            the entries to set
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
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
        result = prime * result + ((entries == null) ? 0 : entries.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((shortUrl == null) ? 0 : shortUrl.hashCode());
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
        if (!(obj instanceof Area)) {
            return false;
        }
        Area other = (Area) obj;
        if (entries == null) {
            if (other.entries != null) {
                return false;
            }
        } else if (!entries.equals(other.entries)) {
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
        builder.append("Area [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", shortUrl=");
        builder.append(shortUrl);
        builder.append(", entries=");
        builder.append(entries);
        builder.append("]");
        return builder.toString();
    }
}
