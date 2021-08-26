package ua.com.alevel.service;

import com.nixsolutions.annotations.BeanClass;
import com.nixsolutions.annotations.InjectBean;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

import java.util.List;

@BeanClass
public class UserServiceImpl implements UserService {

    @InjectBean
    private UserDao dao;

    public void create(User user) {
        dao.create(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
