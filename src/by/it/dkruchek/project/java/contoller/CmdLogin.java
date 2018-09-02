package by.it.dkruchek.project.java.contoller;

import by.it.dkruchek.project.java.beans.Employee;
import by.it.dkruchek.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdLogin extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        if (Util.isPost(req)) {
            String login = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            if (login != null && password != null) {
                String where = String.format(Locale.US,
                        " WHERE email='%s' AND password='%s' ",
                        login, password);
                List<Employee> employees = Dao.getDao().employee.getAll(where);
                if (employees.size() > 0) {
                    Employee employee = employees.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("employee", employee);
                    return Action.PROFILE;
                }
            }
        }
        return null;
    }
}
