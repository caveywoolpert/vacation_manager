package by.it.dkruchek.project.java.dao;

import by.it.dkruchek.project.java.abstractdao.AbstractDAO;
import by.it.dkruchek.project.java.abstractdao.InterfaceDAO;
import by.it.dkruchek.project.java.beans.Employee;
import by.it.dkruchek.project.java.beans.Vacation;
import by.it.dkruchek.project.java.connection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class DaoEmployee extends AbstractDAO implements InterfaceDAO<Employee> {

    @Override
    public Employee read(long id) throws SQLException {
        List<Employee> employees = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (employees.size() > 0) {
            return employees.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Employee employee) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `employees` (`name`, `lastname`, `password`, `email`, `roles_id`) VALUES ('%s','%s','%s', '%s', '%s')",
                employee.getName(), employee.getLastname(), employee.getPassword(), employee.getEmail(), employee.getRole_id());
        employee.setId(executeUpdate(sql));
        return (employee.getId() > 0);
    }

    @Override
    public boolean update(Employee employee) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `employees` " + "SET `name`='%s', `lastname`='%s', `password`='%s',`email`='%s'," + "`roles_id`=%d WHERE id=%d",
                employee.getName(), employee.getLastname(), employee.getPassword(), employee.getEmail(), employee.getRole_id(), employee.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Employee employee) throws SQLException {
        String sql = String.format(
                "DELETE FROM `employees` WHERE `employees`.`id` = %d", employee.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Employee> getAll(String whereAndOrder) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees " + whereAndOrder;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            Employee employee = null;
            while (resultSet.next()) {
            employee = new Employee(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("lastname"),
                    resultSet.getString("password"),
                    resultSet.getString("email"),
                    resultSet.getLong("roles_id"));
            employees.add(employee);
            }
        }
        return employees;
    }

    public HashMap<Employee, List<Vacation>> getFullList() throws SQLException{
        HashMap<Employee, List<Vacation>> fullList = new HashMap<>();
        List<Employee> employees = getAll("");
        for (Employee employee : employees) {
            String where = String.format(Locale.US, "WHERE employees_id=%d", employee.getId());
            List<Vacation> vacations = Dao.getDao().vacation.getAll(where);
            fullList.put(employee, vacations);
        }
        return fullList;
    }
}
