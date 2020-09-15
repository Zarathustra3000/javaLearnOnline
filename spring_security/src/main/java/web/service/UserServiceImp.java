package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.dao.UserDAO;
import web.model.Role;
import web.model.User;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @PostConstruct
    public void init(){
        Role[] roles = {new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        Set<Role> allRoles = new HashSet<>(Arrays.asList(roles));
        roleDao.createRole(allRoles);
        User admin = new User("a","admin@mail","a",allRoles);
        userDAO.add(admin);
    }



    @Override
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void remove(Long id) {
        userDAO.remove(id);
    }

    @Override
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    @Override
    public void createRole(Set<Role> roles) {
        roleDao.createRole(roles);
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
