package by.it.dkruchek.project.java.contoller;

import by.it.dkruchek.project.java.beans.Employee;
import by.it.dkruchek.project.java.beans.Vacation;
import by.it.dkruchek.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class CmdVacation extends Cmd {

    private Calendar calendar;

    @Override
    Action execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object oEmployee = session.getAttribute("employee");
        if (oEmployee == null)
            return Action.LOGIN;
        Employee employee = (Employee) oEmployee;
        if (!Util.isPost(req)) {
            calendar = Calendar.getInstance();
            String currDate = new SimpleDateFormat("dd.MM.YYYY").format(calendar.getTime());
            req.setAttribute("tomorrow", currDate);
        } else {
            long startDate = Util.getDate(req, "start_date").getTime();
            long endDate = Util.getDate(req, "end_date").getTime();
            boolean approved = false;
            long employees_id = employee.getId();
            Vacation vacation = new Vacation(0, startDate, endDate, approved, employees_id);
            Dao.getDao().vacation.create(vacation);
        }
        return null;
    }
}
