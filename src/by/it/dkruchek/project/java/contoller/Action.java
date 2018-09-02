package by.it.dkruchek.project.java.contoller;

enum Action {
    INDEX {
        {
            cmd = new CmdIndex();
        }
    }, LOGIN {
        {
            cmd = new CmdLogin();
        }
    }, SIGNUP {
        {
            cmd = new CmdSignUp();
        }
    }, ERROR {
        {
            cmd = new CmdError();
        }
    }, VACATION {
        {
            cmd = new CmdVacation();
        }
    }, PROFILE {
        {
            cmd = new CmdProfile();
        }
    }, RESETDB {
        {
            cmd = new CmdResetDB();
        }
    }, EDITUSERS {
        {
            cmd = new CmdEditUsers();
        }
    };

    Cmd cmd = new CmdError();
    String jsp = "/" + this.toString().toLowerCase() + ".jsp";
}
