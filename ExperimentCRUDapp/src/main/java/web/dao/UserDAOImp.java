package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void add(User user) {
        getEntityManager().persist(user);
    }

    @Override
    public void remove(Long id) {
        getEntityManager().createQuery("delete from User user where user.id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void edit(User user) {
        getEntityManager().merge(user);
    }

    @Override
    public User getById(Long id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public List<User> allUsers() {
        return getEntityManager().createQuery("From User").getResultList();
    }

}
