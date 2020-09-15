package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void remove(Long id);
    void edit(User user);
    User getById(Long id);
    User getUserByName(String name);
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}
