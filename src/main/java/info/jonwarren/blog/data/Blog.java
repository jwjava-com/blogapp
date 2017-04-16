/**
 * 
 */
package info.jonwarren.blog.data;

import java.util.List;

/**
 * Data container for the blog.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
//TODO: add JPA annotations
//TODO: create tests
public class Blog {

    private String name;
    private String description;
    private List<Area> areas;
    private Owner owner;
    private Copyright copyright;
    private Contact contact;

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the areas
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * @param areas
     *            the areas to set
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner
     *            the owner to set
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
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

    /**
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact
     *            the contact to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
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
        result = prime * result + ((areas == null) ? 0 : areas.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result + ((copyright == null) ? 0 : copyright.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
        if (!(obj instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) obj;
        if (areas == null) {
            if (other.areas != null) {
                return false;
            }
        } else if (!areas.equals(other.areas)) {
            return false;
        }
        if (contact == null) {
            if (other.contact != null) {
                return false;
            }
        } else if (!contact.equals(other.contact)) {
            return false;
        }
        if (copyright == null) {
            if (other.copyright != null) {
                return false;
            }
        } else if (!copyright.equals(other.copyright)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (owner == null) {
            if (other.owner != null) {
                return false;
            }
        } else if (!owner.equals(other.owner)) {
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
        builder.append("Blog [name=");
        builder.append(name);
        builder.append(", description=");
        builder.append(description);
        builder.append(", areas=");
        builder.append(areas);
        builder.append(", owner=");
        builder.append(owner);
        builder.append(", copyright=");
        builder.append(copyright);
        builder.append(", contact=");
        builder.append(contact);
        builder.append("]");
        return builder.toString();
    }
}
