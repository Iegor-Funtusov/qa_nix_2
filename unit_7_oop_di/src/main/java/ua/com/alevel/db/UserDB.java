package ua.com.alevel.db;

import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UserDB {

    private List<User> users = new ArrayList<>();

    public void create(User user) {
        Random random = new Random(1_000_000);
        user.setId(random.nextInt());
        users.add(user);
    }

    public void update(User user) {
        User current = users.stream().filter(u -> u.getId() == user.getId()).findFirst().get();
        current.setName(user.getName());
        current.setAge(user.getAge());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public User findById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public List<User> findAll() {
        return users;
    }
}
