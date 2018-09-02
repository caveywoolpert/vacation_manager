package by.it.dkruchek.project.java.contoller;


import by.it.dkruchek.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

class CmdResetDB extends Cmd {
    @Override
    Action execute(HttpServletRequest req) {
        Dao.reset();
        HttpSession session = req.getSession();
        session.invalidate();
        return Action.LOGIN;
    }
}
