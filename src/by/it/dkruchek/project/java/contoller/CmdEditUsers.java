package by.it.dkruchek.project.java.contoller;


import by.it.dkruchek.project.java.beans.Employee;
import by.it.dkruchek.project.java.beans.Role;
import by.it.dkruchek.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            Long id = Util.getLong(req, "id");
            String name = Util.getString(req, "name");
            String lastname = Util.getString(req, "lastname");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            Long rolesId = Util.getLong(req, "roles_id");
            Employee employee = new Employee(id, name, lastname, password, email, rolesId);
            if (req.getParameter("Update") != null) {
                dao.employee.update(employee);
            } else if (req.getParameter("Delete") != null) {
                dao.employee.delete(employee);
            }
        }
        List<Employee> employees = dao.employee.getAll("");
        req.setAttribute("employees", employees);
        List<Role> roles = dao.role.getAll("");
        req.setAttribute("roles", roles);
        return null;
    }
}
