package ua.com.alevel.dao;

import com.nixsolutions.annotations.BeanClass;
import com.nixsolutions.annotations.InjectBean;
import ua.com.alevel.db.UserDB;
import ua.com.alevel.entity.User;

import java.util.List;

//@Deprecated
@BeanClass
public class UserInMemoryDao implements UserDao {

    private UserDB db = new UserDB();

    public UserInMemoryDao() {
        System.out.println("UserDao.UserDao");
    }

    public void create(User user) {
        db.create(user);
    }

    public void update(User user) {
        db.update(user);
    }

    public void delete(int id) {
        db.delete(id);
    }

    public User findById(int id) {
        return db.findById(id);
    }

    public List<User> findAll() {
        return db.findAll();
    }
}
//nix_qa_2_di