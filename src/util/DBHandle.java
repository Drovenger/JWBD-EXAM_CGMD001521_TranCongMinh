package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static util.Error.*;

public class DBHandle {

    private DBHandle() {
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC.JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC.DATABASE_URL, JDBC.USER, JDBC.PASSWORD);
        } catch (SQLException ex) {
            System.err.println(ERROR_001);
        } catch (ClassNotFoundException ex) {
            System.err.println(ERROR_002);
        }
        return connection;
    }
}
