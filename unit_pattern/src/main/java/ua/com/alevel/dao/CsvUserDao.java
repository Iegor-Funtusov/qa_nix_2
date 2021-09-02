package ua.com.alevel.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;
import ua.com.alevel.config.FileType;
import ua.com.alevel.entity.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("CsvUserDao")
public class CsvUserDao extends AbstractDao implements UserDao, FileIO {

    private final List<String[]> csvData = new ArrayList<>();

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
        try(CSVReader reader = new CSVReader(new FileReader(FileType.CSV_TYPE.getPath()))) {
            super.users.clear();
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                try {
                    User user = User.newUser()
                            .setId(re[0])
                            .setFirstName(re[1])
                            .setLastName(re[2])
                            .setEmail(re[3])
                            .setBirthDay(new Date(Long.parseLong(re[4])))
                            .build();
                    super.users.add(user);
                } catch (Exception e) {
                    System.out.println("e = " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeUsers() {
        this.csvData.clear();
        writeHeader();
        for (User u : super.users) {
            String[] currentUser = new String[5];
            currentUser[0] = u.getId();
            currentUser[1] = u.getFirstName();
            currentUser[2] = u.getLastName();
            currentUser[3] = u.getEmail();
            currentUser[4] = String.valueOf(u.getBirthDay().getTime());
            csvData.add(currentUser);
        }
        try(CSVWriter writer = new CSVWriter(new FileWriter(FileType.CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeHeader() {
        String[] header = { "id", "firstName", "lastName", "email", "birthDay" };
        csvData.add(header);
    }
}
