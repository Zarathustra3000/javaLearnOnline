package web.dao;

import java.util.Set;
import web.model.Role;

public interface RoleDao {
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}
