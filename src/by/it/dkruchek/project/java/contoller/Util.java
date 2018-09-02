package by.it.dkruchek.project.java.contoller;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Util {

    private static final String POST = "POST";
    private static final String INTEGER = "-?[0-9]+";
    private static final String DATE = "[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String EXCLUDE_SQL = "^((?!SELECT|DROP|INSERT|UPDATE|DELETE|GRANT|INVOKE).)*$\n";

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase(POST);
    }

    private static String getString(HttpServletRequest req, String field, String pattern) {
        String value = req.getParameter(field);
        if (value.matches(pattern))
            return value;
        else
            req.setAttribute("help_" + field, field + " incorrect");
            return null;
    }

    static String getString(HttpServletRequest req, String field) {
        // TODO: SQL injections
        return getString(req, field, ".*");
    }

    static Integer getInteger(HttpServletRequest req, String field) {
        String value = getString(req, field, INTEGER);
        if (value == null)
            return null;
        else
            // TODO help
            return Integer.valueOf(value);
    }

    static Long getLong(HttpServletRequest req, String field) {
        String value = getString(req, field, INTEGER);
        if (value == null)
            return null;
        else
            // TODO help

            return Long.valueOf(value);
    }

    static Date getDate(HttpServletRequest req, String field) throws ParseException {
        String date = getString(req, field, DATE);
        if (date == null){
            return null;
        } else {
            // TODO help

            DateFormat format = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
            return format.parse(date);
        }
    }

}
