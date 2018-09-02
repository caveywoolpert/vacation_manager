package by.it.dkruchek.project.java.contoller;

import by.it.dkruchek.project.java.beans.Employee;
import by.it.dkruchek.project.java.beans.Vacation;
import by.it.dkruchek.project.java.dao.Dao;
import by.it.dkruchek.project.java.calendar.Month;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CmdIndex extends Cmd{
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Month month = Month.getInstance();
        String currMonthName = month.getName();
        req.setAttribute("curr_month_name", currMonthName);

        String currYear = month.getYear();
        req.setAttribute("curr_year", currYear);

        int currMonthDays = month.getDaysNumber();
        req.setAttribute("curr_month_days", currMonthDays);

        req.setAttribute("month_class", month);


        HashMap<Employee, List<Vacation>> empVacations = Dao.getDao().employee.getFullList();
        HashMap<Employee, Month.Vacation> calendarVacations = new HashMap<>();

        for (Map.Entry<Employee, List<Vacation>> employeeListEntry : empVacations.entrySet()) {
            Employee employee = employeeListEntry.getKey();
            List<Vacation> vacationsList= employeeListEntry.getValue();
            List<Integer> v_days = new ArrayList<>();
            Month.Vacation vac = null;
            for (Vacation vacation : vacationsList) {
                for (int i = 1; i <= currMonthDays; i++) {
                    if (month.show(vacation.getStartdate(), vacation.getEnddate(), i))
                        v_days.add(i);
                }
                vac = month. new Vacation(v_days, vacation.isApproved());
            }
            calendarVacations.put(employee, vac);
        }
        req.setAttribute("full_list", calendarVacations);

        if (Util.isPost(req)) {
            if (req.getParameter("prev") != null){
                month.switchToPreviousMonth();
                return Action.INDEX;
            }
            else if (req.getParameter("next") != null){
                month.switchToNextMonth();
                return Action.INDEX;
            }
        }

        return null;
    }
}
