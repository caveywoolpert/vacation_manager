package by.it.dkruchek.project.java.beans;

public class Vacation {

    long id;
    long startdate;
    long enddate;
    boolean approved;
    long employees_id;

    public Vacation() {
    }

    public Vacation(long id, long startdate, long enddate, boolean approved, long employees_id) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.approved = approved;
        this.employees_id = employees_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public long getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(long employees_id) {
        this.employees_id = employees_id;
    }

    public long getStartdate() {
        return startdate;
    }

    public void setStartdate(long startdate) {
        this.startdate = startdate;
    }

    public long getEnddate() {
        return enddate;
    }

    public void setEnddate(long enddate) {
        this.enddate = enddate;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "id=" + id +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", approved=" + approved +
                ", employees_id=" + employees_id +
                '}';
    }
}
