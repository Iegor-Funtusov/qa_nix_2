package ua.com.alevel.dao;

import ua.com.alevel.config.Ignore;
import ua.com.alevel.db.UserDB;
import ua.com.alevel.entity.User;

import java.util.List;

//@Ignore
public class UserDaoListImpl implements UserDao {

    private UserDB db = new UserDB();

    public UserDaoListImpl() {
        System.out.println("UserDaoListImpl.UserDaoListImpl");
    }

    public void create(User user) {
        db.create(user);
    }

    public void update(User user) {
        db.update(user);
    }

    public void delete(String id) {
        db.delete(id);
    }

    public User findById(String id) {
        return db.findById(id);
    }

    public List<User> findAll() {
        return db.findAll();
    }
}
