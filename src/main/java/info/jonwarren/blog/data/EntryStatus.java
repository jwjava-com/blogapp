/**
 * 
 */
package info.jonwarren.blog.data;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Data container for entry statuses.
 *
 * @author Jon Warren <jon@jonwarren.info>
 */
@Entity
@Table(name = "statuses")
public class EntryStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private Long id;

    @NotNull
    @Column(name = "status_name")
    private Status status;

    @NotNull
    @Column(name = "status_ts")
    private Instant timestamp;

    /**
     * Creates an {@link EntryStatus} object set to the provided {@link Status}.
     * 
     * @param status
     *            the {@link Status} to use
     * @return a new {@link EntryStatus} set to the {@link Status} and {@link Instant#now()}
     * 
     * @see {@link Instant#now()}
     */
    public static EntryStatus createEntryStatus(Status status) {
        EntryStatus entryStatus = new EntryStatus();
        entryStatus.setStatus(status);
        entryStatus.setTimestamp(Instant.now());
        return entryStatus;
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
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the timestamp
     */
    public Instant getTimestamp() {
        return timestamp;
    }

    /**
     * @param ts
     *            the timestamp to set
     */
    public void setTimestamp(Instant ts) {
        if (ts == null || ts == Instant.EPOCH || ts == Instant.MIN || ts == Instant.MAX) {
            ts = Instant.now();
        }
        this.timestamp = ts;
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
        if (!(obj instanceof EntryStatus)) {
            return false;
        }
        EntryStatus other = (EntryStatus) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (status != other.status) {
            return false;
        }
        if (timestamp == null) {
            if (other.timestamp != null) {
                return false;
            }
        } else if (!timestamp.equals(other.timestamp)) {
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
        builder.append("EntryStatus [id=");
        builder.append(id);
        builder.append(", status=");
        builder.append(status);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append("]");
        return builder.toString();
    }
}
