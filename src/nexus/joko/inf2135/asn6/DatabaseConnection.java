package nexus.joko.inf2135.asn6;

import java.sql.*;

/**
 *
 * @author jokosupriyanto
 */
public class DatabaseConnection {

    private static Connection connection = null;

    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/kendaraan";
    private final static String USER = "root";
    private final static String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                System.out.println("Trying connect to database...");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                if (connection != null) {
                    System.out.println("Connection created successfully!");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
