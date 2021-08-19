package ua.com.alevel.type.data;

import java.util.Objects;

public class Admin extends User {

    private final RoleType roleType;

    public Admin() {
        this.roleType = RoleType.ADMIN;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return roleType == admin.roleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleType);
    }
}
