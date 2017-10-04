package ru.job4j.store;

/**
 * Class for creating instance of role.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 03.10.2017.
 */
public class Role extends Base {
    /**
     * Role ID.
     */
    private String id;

    /**
     * Role name.
     */
    private String roleName;

    /**
     * Constructor for Role.
     * @param id - role id.
     * @param roleName - role name.
     */
    public Role(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    /**
     * Get role name.
     * @return String.
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * Return role ID.
     * @return String - ID.
     */
    @Override
    String getId() {
        return this.id;
    }

    /**
     * Set role id.
     * @param id - instance id.
     */
    @Override
    void setId(String id) {
        this.id = id;
    }

    /**
     * Method for comparison this object with object the same type.
     * @param o - an another object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return id != null ? id.equals(role.id) : role.id == null;
    }

    /**
     * HashCode.
     * @return int.
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
