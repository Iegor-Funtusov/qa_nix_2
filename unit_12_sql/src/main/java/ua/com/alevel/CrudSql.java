package ua.com.alevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudSql {

    private Connection connection;
    private Statement statement;

    private static final String CREATE_USER = "insert into user values(default,?,?)";
    private static final String UPDATE_BY_ID_QUERY = "update user set name = ?, age = ? where id = ?";
    private static final String FIND_ALL_USER_QUERY = "select * from user";
    private static final String FIND_USER_BY_ID_QUERY = "select * from user where id = ";
    private static final String DELETE_USER_BY_ID_QUERY = "delete from user where id = ";

    public CrudSql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nix_qa_2_db?useSSL=false&serverTimezone=UTC", "root", "root");
                this.statement = this.connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void create(User user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    public User findById(Integer id) {
        try {
            ResultSet resultSet = this.statement.executeQuery(FIND_USER_BY_ID_QUERY + id);
            while (resultSet.next()) {
                return initUserByResultSet(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        return null;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = this.statement.executeQuery(FIND_ALL_USER_QUERY);
            while (resultSet.next()) {
                users.add(initUserByResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("problem: = " + e.getMessage());
        }
        return users;
    }

    private User initUserByResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        int id = resultSet.getInt("id");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
