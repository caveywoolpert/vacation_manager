package by.it.dkruchek.project.java.abstractdao;

import by.it.dkruchek.project.java.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractDAO {
    public long executeUpdate(String sql) throws SQLException {
        long result = -1;
        try (Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement()) {
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                statement.executeUpdate(sql, statement.RETURN_GENERATED_KEYS);
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next())
                    result = generatedKeys.getLong(1);
            } else {
                result = statement.executeUpdate(sql);
            }
        }
        return result;
    }
}