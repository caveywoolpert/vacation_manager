package by.it.dkruchek.project.java.contoller;

import by.it.dkruchek.project.java.dao.Dao;
import by.it.dkruchek.project.java.beans.Employee;

import javax.servlet.http.HttpServletRequest;

class CmdSignUp extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws Exception {

        if (Util.isPost(req)) {
            String name = Util.getString(req, "name");
            String lastName = Util.getString(req, "lastname");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            if (name != null && lastName != null && email != null && password != null) {
                Employee employee = new Employee(0, name, lastName, password, email, 3);
                Dao.getDao().employee.create(employee);
                if (employee.getId() > 0)
                    return Action.LOGIN;
            }
        }

        return null;
    }
}
