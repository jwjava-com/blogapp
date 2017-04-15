/**
 * 
 */
package info.jonwarren.blog.data;

import java.time.Instant;
import java.time.Year;

/**
 * Data container for copyright info.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
//TODO: add JPA annotations
//TODO: create tests
public class Copyright {

    private String displayTemplate = "";
    private Year originalYear = Year.from(Instant.now());
    private Year modificationYear;
    private boolean modified = false;
    private boolean ownerNamePublic = true;

    /**
     * @return the displayTemplate
     */
    public String getDisplayTemplate() {
        return displayTemplate;
    }

    /**
     * @param displayTemplate
     *            the displayTemplate to set
     */
    public void setDisplayTemplate(String displayTemplate) {
        this.displayTemplate = displayTemplate;
    }

    /**
     * @return the originalYear
     */
    public Year getOriginalYear() {
        return originalYear;
    }

    /**
     * @param originalYear
     *            the originalYear to set
     */
    public void setOriginalYear(Year originalYear) {
        this.originalYear = originalYear;
        if (this.modificationYear != null && !this.modificationYear.equals(originalYear)) {
            setModified(true);
        } else {
            setModified(false);
        }
    }

    /**
     * @return the modificationYear
     */
    public Year getModificationYear() {
        return modificationYear;
    }

    /**
     * @param modificationYear
     *            the modificationYear to set
     */
    public void setModificationYear(Year modificationYear) {
        this.modificationYear = modificationYear;
        if (this.originalYear != null && !this.originalYear.equals(modificationYear)) {
            setModified(true);
        } else {
            setModified(false);
        }
    }

    /**
     * @return the modified
     */
    public boolean isModified() {
        return modified;
    }

    /**
     * @param modified
     *            the modified to set
     */
    public void setModified(boolean modified) {
        this.modified = modified;
    }

    /**
     * @return the ownerNamePublic
     */
    public boolean isOwnerNamePublic() {
        return ownerNamePublic;
    }

    /**
     * @param ownerNamePublic
     *            the ownerNamePublic to set
     */
    public void setOwnerNamePublic(boolean ownerNamePublic) {
        this.ownerNamePublic = ownerNamePublic;
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
        result = prime * result + ((displayTemplate == null) ? 0 : displayTemplate.hashCode());
        result = prime * result + ((modificationYear == null) ? 0 : modificationYear.hashCode());
        result = prime * result + (modified ? 1231 : 1237);
        result = prime * result + ((originalYear == null) ? 0 : originalYear.hashCode());
        result = prime * result + (ownerNamePublic ? 1231 : 1237);
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
        if (!(obj instanceof Copyright)) {
            return false;
        }
        Copyright other = (Copyright) obj;
        if (displayTemplate == null) {
            if (other.displayTemplate != null) {
                return false;
            }
        } else if (!displayTemplate.equals(other.displayTemplate)) {
            return false;
        }
        if (modificationYear == null) {
            if (other.modificationYear != null) {
                return false;
            }
        } else if (!modificationYear.equals(other.modificationYear)) {
            return false;
        }
        if (modified != other.modified) {
            return false;
        }
        if (originalYear == null) {
            if (other.originalYear != null) {
                return false;
            }
        } else if (!originalYear.equals(other.originalYear)) {
            return false;
        }
        if (ownerNamePublic != other.ownerNamePublic) {
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
        builder.append("Copyright [displayTemplate=");
        builder.append(displayTemplate);
        builder.append(", originalYear=");
        builder.append(originalYear);
        builder.append(", modificationYear=");
        builder.append(modificationYear);
        builder.append(", modified=");
        builder.append(modified);
        builder.append(", ownerNamePublic=");
        builder.append(ownerNamePublic);
        builder.append("]");
        return builder.toString();
    }
}
