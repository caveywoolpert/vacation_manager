package by.it.dkruchek.project.java.dao.reset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class C_Reset {

    // static block to load driver
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
             Statement statement = connection.createStatement()) {
        statement.executeUpdate("DROP SCHEMA IF EXISTS `dkruchek`;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
