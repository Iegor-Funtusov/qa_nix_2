package ua.com.alevel.dao;

import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDao {

    protected List<User> users = new ArrayList<>();

    protected void createUser(User user) {
        user.setId(generateId());
        users.add(user);
    }

    protected void updateUser(User user) {
        if (existById(user.getId())) {
            User current = findUserById(user.getId());
            current.setId(user.getId());
            current.setFirstName(user.getFirstName());
            current.setLastName(user.getLastName());
            current.setEmail(user.getEmail());
            current.setBirthDay(user.getBirthDay());
        }
    }

    protected void deleteDelete(String id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    protected User findUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    protected User findUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
    }

    protected List<User> findAllUsers() {
        return users;
    }

    protected boolean existUserByEmail(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (existById(id)) {
            return generateId();
        }
        return id;
    }

    private boolean existById(String id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }
}
