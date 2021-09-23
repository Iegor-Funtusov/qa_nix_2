package ua.com.alevel;

import java.util.List;

public class SqlMain {

    public static void main(String[] args) {
        CrudSql sql = new CrudSql();
//        create(sql);
//        findAll(sql);
        findById(sql);
    }

    private static void create(CrudSql sql) {
        User user = new User();
        user.setName("test3");
        user.setAge(14);
        sql.create(user);
    }

    private static void findAll(CrudSql sql) {
        List<User> users = sql.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    private static void findById(CrudSql sql) {
        User user = sql.findById(6);
        System.out.println("user = " + user);
    }
}
