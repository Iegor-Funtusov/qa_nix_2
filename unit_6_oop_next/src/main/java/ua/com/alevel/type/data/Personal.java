package ua.com.alevel.type.data;

import java.util.Objects;

public class Personal extends User {

    private final RoleType roleType;

    public Personal() {
        this.roleType = RoleType.PERSONAL;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personal)) return false;
        if (!super.equals(o)) return false;
        Personal personal = (Personal) o;
        return roleType == personal.roleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roleType);
    }
}
