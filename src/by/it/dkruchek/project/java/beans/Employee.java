package by.it.dkruchek.project.java.beans;

public class Employee {

    Long id;
    String name;
    String lastname;
    String password;
    String email;
    Long roles_id;

    public Employee() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole_id(long roles_id) {
        this.roles_id = roles_id;
    }

    public Employee(long id, String name, String lastname, String password, String email, long role_id) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.roles_id = role_id;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getRole_id() {
        return roles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
