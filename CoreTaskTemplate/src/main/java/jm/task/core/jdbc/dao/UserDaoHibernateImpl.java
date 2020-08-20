package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {

    private Session session = getConnectionHibernate().openSession();
    //private UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try {
            session.createSQLQuery("CREATE TABLE USERS (id long, firstName varchar(45), lastName varchar(45), age int)")
                    .executeUpdate();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session.createSQLQuery("DROP TABLE USERS")
                    .executeUpdate();
            session.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name,lastName,age);
        session.save(user);
        try {
            session.getTransaction().commit();
        } catch (Exception e){

        }
        //session.getTransaction().commit();
        session.clear();
//        String sql = "INSERT INTO `users` (`name`, `lastname`, `age`) " +
//                "VALUES ('" + name + "', '" + lastName + "', " + age + ")";
//        try {
//            session.createSQLQuery(sql)
//                    .executeUpdate();
//            session.close();
//        } catch (Exception e) {
//
//        }
        //session.createSQLQuery(sql);
    }

    @Override
    public void removeUserById(long id) {
       // userDaoJDBC.dropUsersTable();
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return null;
    }

    @Override
    public void cleanUsersTable() {
        String sql = "DELETE FROM users";
        session.createSQLQuery(sql);
    }

    private void processingSQLQuery(String sqlQuery) {
//        try {
//            sessionFactory = getConnectionHibernate().openSession();
//            statement.executeUpdate(sqlQuery);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
