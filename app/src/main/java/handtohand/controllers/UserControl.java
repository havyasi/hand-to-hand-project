package handtohand.controllers;

import java.sql.ResultSet;
import handtohand.Config.DbConfig;
import handtohand.model.User;

public class UserControl extends DbConfig {

    public static User login(String username, String password) {
        query = "SELECT * FROM user WHERE username=? AND password=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet userResult = preparedStatement.executeQuery()) {
                if (userResult.next()) {
                    int id = userResult.getInt("id");
                    String role = userResult.getString("role");
                    String username1 = userResult.getString("username");
                    User user = new User(id, role, username1 );
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean registerUser(String username, String password) {
        query = "INSERT INTO user (username, password, role) VALUES (?, ?, 'user')";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUserById(int id) {
        query = "SELECT * FROM user WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            try (ResultSet userResult = preparedStatement.executeQuery()) {
                while (userResult.next()) {
                    String username = userResult.getString("username");
                    String profesi = userResult.getString("profesi");
                    String name = userResult.getString("nama");
                    String hobby = userResult.getString("hobby");
                    String mottohidup = userResult.getString("mottohidup");
                    int usia = userResult.getInt("usia");
                    String role = userResult.getString("role");
                    User user = new User(id, username, profesi, name, hobby, mottohidup, role, usia);
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateUser(int id, String username, String nama, String profesi, String mottohidup, String hobby, int usia) {
        query = "UPDATE user SET username=?, profesi=?, nama=?, hobby=?, mottohidup=?, usia=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, profesi);
            preparedStatement.setString(3, nama);
            preparedStatement.setString(4, hobby);
            preparedStatement.setString(5, mottohidup);
            preparedStatement.setInt(6, usia);
            preparedStatement.setInt(7, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
