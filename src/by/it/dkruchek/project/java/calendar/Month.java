package by.it.dkruchek.project.java.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Month {

    private static volatile Month instance;
    private Calendar today = Calendar.getInstance();
    private Calendar calendar_aux = Calendar.getInstance();

    public static Month getInstance() {
        Month localInstance = instance;
        if (localInstance == null) {
            synchronized (Month.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Month();
                }
            }
        }
        return localInstance;
    }

    public class Vacation {

        List<Integer> dates;
        boolean approved;

        public Vacation(List<Integer> dates, boolean approved) {
            this.dates = dates;
            this.approved = approved;
        }

        public List<Integer> getDates() {
            return dates;
        }

        public void setDates(List<Integer> dates) {
            this.dates = dates;
        }

        public boolean isApproved() {
            return approved;
        }

        public void setApproved(boolean approved) {
            this.approved = approved;
        }
    }

    public void switchToNextMonth() {
        this.today.add(Calendar.MONTH, 1);

    }

    public void switchToPreviousMonth() {
        this.today.add(Calendar.MONTH, -1);

    }

    public int getDaysNumber() {
        return today.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public String getName() {
        return new SimpleDateFormat("MMMM").format(today.getTime());
    }

    public String getYear() {
        return new SimpleDateFormat("YYYY").format(today.getTime());
    }


    public boolean show(long startDate, long endDate, int currMonthDay) {
        Date startDate_d = new Date(startDate);
        Date endDate_d = new Date(endDate + (1000 * 60 * 60 * 24));
        calendar_aux.clear();
        calendar_aux.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), currMonthDay, 1, 0, 0);
        Date dayStart = calendar_aux.getTime();
        return dayStart.after(startDate_d) && dayStart.before(endDate_d);
    }
}
