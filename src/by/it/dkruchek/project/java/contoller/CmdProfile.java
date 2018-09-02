package by.it.dkruchek.project.java.contoller;

import by.it.dkruchek.project.java.beans.Employee;
import by.it.dkruchek.project.java.beans.Vacation;
import by.it.dkruchek.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

class CmdProfile extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oEmployee = session.getAttribute("employee");
        if (oEmployee == null){
            return Action.LOGIN;
        }
        Employee employee = (Employee) oEmployee;

        if (Util.isPost(req)) {
            if (req.getParameter("logout") != null){
                session.invalidate();
                return Action.LOGIN;
            }
        }

        String where = String.format(Locale.US, " WHERE employees_id=%d", employee.getId());
        List<Vacation> vacations = Dao.getDao().vacation.getAll(where);
        req.setAttribute("vacations",vacations);
        return null;
    }
}