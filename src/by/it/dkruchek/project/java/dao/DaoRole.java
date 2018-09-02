package by.it.dkruchek.project.java.dao;

import by.it.dkruchek.project.java.abstractdao.AbstractDAO;
import by.it.dkruchek.project.java.abstractdao.InterfaceDAO;
import by.it.dkruchek.project.java.beans.Role;
import by.it.dkruchek.project.java.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoRole extends AbstractDAO implements InterfaceDAO<Role> {

    @Override
    public Role read(long id) throws SQLException {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `roles` (`role`) VALUES ('%s')",
                role.getRole());
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `roles` " + "SET `role`='%s' WHERE id=%d",
                role.getRole(), role.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(
                "DELETE FROM `roles` WHERE `roles`.`id` = %d", role.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Role> getAll(String whereAndOrder) throws SQLException {
        List<Role> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles " + whereAndOrder;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Role role = null;
            while (resultSet.next()) {
                role = new Role(resultSet.getLong("id"),
                        resultSet.getString("role"));
                roles.add(role);
            }
        }
        return roles;
    }
}
