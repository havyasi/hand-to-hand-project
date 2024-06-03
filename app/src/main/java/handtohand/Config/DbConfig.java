package handtohand.Config;

// import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConfig {
    private static final String DB_URL = "jdbc:sqlite:src/main/resources/database/db_library.db";

    protected static Connection connection;
    // protected static Statement statement;
    protected static PreparedStatement preparedStatement;
    protected static ResultSet resultset;
    protected  static String query;

    public static void getConnection(){
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
