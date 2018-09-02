package by.it.dkruchek.project.java.dao;

import by.it.dkruchek.project.java.abstractdao.AbstractDAO;
import by.it.dkruchek.project.java.abstractdao.InterfaceDAO;
import by.it.dkruchek.project.java.beans.Vacation;
import by.it.dkruchek.project.java.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoVacation extends AbstractDAO implements InterfaceDAO<Vacation> {

    @Override
    public Vacation read(long id) throws SQLException {
        List<Vacation> vacations = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (vacations.size() > 0) {
            return vacations.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Vacation vacation) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `vacations` (`startdate`, `enddate`, `approved`, `employees_id`) VALUES ('%s','%s',%b,'%s')",
                vacation.getStartdate(), vacation.getEnddate(), vacation.isApproved(), vacation.getEmployees_id());
        vacation.setId(executeUpdate(sql));
        return (vacation.getId() > 0);
    }

    @Override
    public boolean update(Vacation vacation) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `vacations` " + "SET `startdate`='%s', `enddate`='%s',`approved`=%b," + "`employees_id`=%d WHERE id=%d",
                vacation.getStartdate(), vacation.getEnddate(), vacation.isApproved(), vacation.getEmployees_id(), vacation.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Vacation vacation) throws SQLException {
        String sql = String.format(
                "DELETE FROM `vacations` WHERE `vacations`.`id` = %d", vacation.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Vacation> getAll(String whereAndOrder) throws SQLException {
        List<Vacation> vacations = new ArrayList<>();
        String sql = "SELECT * FROM vacations " + whereAndOrder;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Vacation vacation = null;
            while (resultSet.next()) {
                vacation = new Vacation(resultSet.getLong("id"),
                        resultSet.getLong("startDate"),
                        resultSet.getLong("endDate"),
                        resultSet.getBoolean("approved"),
                        resultSet.getLong("employees_id"));
                vacations.add(vacation);
            }
        }
        return vacations;
    }
}
