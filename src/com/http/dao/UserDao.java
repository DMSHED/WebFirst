package com.http.dao;

import com.http.entity.Gender;
import com.http.entity.Role;
import com.http.entity.User;
import com.http.util.ConnectionPool;
import com.http.util.LocalDateFormatter;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User>{

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
            INSERT INTO users (name, birthday, email, password, role, gender, image) 
            VALUES (?, ?, ?, ?, ?, ?, ?);
            """;

    private static final String FIND_BY_EMAIL_AND_PASSWORD = """
            SELECT 
                *
            FROM users
            WHERE email = ? and password = ?;
            """;

    private UserDao(){}



    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (var connection = ConnectionPool.get();
        var preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_AND_PASSWORD)) {


            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()){
                user = buildEntity(resultSet);
            }

            return Optional.ofNullable(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public User save(User entity) {
        try(Connection connection = ConnectionPool.get();
        PreparedStatement prepareStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)){
            prepareStatement.setObject(1, entity.getName());
            prepareStatement.setObject(2,entity.getBirthday());
            prepareStatement.setObject(3,entity.getEmail());
            prepareStatement.setObject(4,entity.getPassword());
            prepareStatement.setObject(5,entity.getRole().name());
            prepareStatement.setObject(6,entity.getGender().name());
            prepareStatement.setObject(7, entity.getImage());

            prepareStatement.executeUpdate();

            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {

    }

    public static UserDao getInstance(){
        return INSTANCE;
    }

    private static User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .image(resultSet.getObject("image", String.class))
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.valueOf(resultSet.getObject("role", String.class)))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }

}
