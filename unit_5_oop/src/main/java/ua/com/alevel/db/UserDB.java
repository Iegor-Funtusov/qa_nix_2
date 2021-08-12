package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDB {

    private List<User> users = new ArrayList<>();

//    private List<BaseEntity> list = new ArrayList<>();

    public void create(User user) {
        user.setId(generateId());
        users.add(user);
    }

    public void update(User user) {
        User current = users.stream().filter(u -> u.getId().equals(user.getId())).findFirst().get();
        current.setName(user.getName());
        current.setAge(user.getAge());
    }

    public void delete(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    public User findById(String id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

    public List<User> findAll() {
        return users;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (users.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
