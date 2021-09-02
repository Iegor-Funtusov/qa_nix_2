package ua.com.alevel.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.FileType;
import ua.com.alevel.entity.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service("JsonUserDao")
public class JsonUserDao extends AbstractDao implements UserDao, FileIO {

    @Override
    public void create(User user) {
        loadUsers();
        createUser(user);
        storeUsers();
    }

    @Override
    public void update(User user) {
        loadUsers();
        updateUser(user);
        storeUsers();
    }

    @Override
    public void delete(String id) {
        loadUsers();
        deleteDelete(id);
        storeUsers();
    }

    @Override
    public User findById(String id) {
        loadUsers();
        return findUserById(id);
    }

    @Override
    public boolean existByEmail(String email) {
        loadUsers();
        return existUserByEmail(email);
    }

    @Override
    public List<User> findAll() {
        loadUsers();
        return findAllUsers();
    }

    @Override
    public void loadUsers() {
        super.users.clear();
        try {
            String usersOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            super.users = objectMapper.readValue(usersOut, new TypeReference<>() { });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeUsers() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context) -> new Date(json.getAsJsonPrimitive().getAsLong()))
                .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
                .create();
        String usersOut = gson.toJson(users);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(usersOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
