package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("userDao")
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Transactional
    @Override
    public void add(User user) {
        getEntityManager().persist(user);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        getEntityManager().remove(getById(id));
    }

    @Transactional
    @Override
    public void edit(User user) {
        getEntityManager().merge(user);
    }

    @Transactional
    @Override
    public User getById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Transactional
    @Override
    @SuppressWarnings("uncheckrd")
    public List<User> allUsers() {
        return getEntityManager().createQuery("select user From User user").getResultList();
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return (User) getEntityManager().createQuery("select user from User user where user.name=:name")
                .setParameter("name", name)
                .getSingleResult();
    }
}
