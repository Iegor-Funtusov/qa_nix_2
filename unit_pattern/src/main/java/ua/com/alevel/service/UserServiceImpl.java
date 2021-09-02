package ua.com.alevel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.DaoFactory;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    private final UserDao userDao = DaoFactory.getInstance().getUserDao();
    private final UserDao userDao;
//    @Autowired
//    @Qualifier("CsvUserDao")
//    private UserDao userDao;

    public UserServiceImpl(@Qualifier("JsonUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void create(User user) {
        if (!userDao.existByEmail(user.getEmail())) {
            userDao.create(user);
        }
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
