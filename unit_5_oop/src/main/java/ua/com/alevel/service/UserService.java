package ua.com.alevel.service;

import ua.com.alevel.config.ObjectFactory;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.UserDaoListImpl;
import ua.com.alevel.dao.UserDaoSetImpl;
import ua.com.alevel.entity.User;

import java.util.List;

public class UserService {

//    private UserDao dao = ObjectFactory.getObjectFactory().getImplClassByInterface(UserDao.class);
    private UserDao dao = new UserDaoListImpl();

    public void create(User user) {
        dao.create(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public void delete(String id) {
        dao.delete(id);
    }

    public User findById(String id) {
        return dao.findById(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
