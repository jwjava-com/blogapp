/**
 * 
 */
package info.jonwarren.blog.data;

import java.time.Instant;

/**
 * Data container for entry statuses.
 *
 * @author Jon Warren <jon@jonwarren.info>
 */
public class EntryStatus {

    private Status status;
    private Instant timestamp;

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
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
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
        builder.append("EntryStatus [status=");
        builder.append(status);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append("]");
        return builder.toString();
    }
}
