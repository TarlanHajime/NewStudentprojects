package user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Student extends Person implements Serializable {

    private int id;
    private String email;
    private String username;
    private String password;
    private boolean isBLocked = false;


    public Student(int id, String email, String username, String password, String name, String surname, LocalDate birthday) {
        super(name, surname, birthday);
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Student (String name, String surname, LocalDate birthday) {
        super(name, surname, birthday);


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBLocked() {
        return isBLocked;
    }

    public void setBLocked(boolean BLocked) {
        isBLocked = BLocked;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void blockStudent() {
        this.isBLocked = true;
        System.out.println("Student " + this.id + " " + this.username + " " + "has been blocked!");
    }

    public void unBlockStudent() {
        this.isBLocked = false;
        System.out.println("Student " + this.id + " " + this.username + " " + "has been unblocked!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBLocked=" + isBLocked +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", age = " + Period.between(birthday, LocalDate.now()).getYears() +
                '}' + "\n";
    }

    public String getDetailsForTeacher() {
        LocalDate currentTime = LocalDate.now();
        int age = Period.between(birthday, currentTime).getYears();
        return "Teacher{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", age --> " + age + "\n" +
                '}' + "\n";
    }
}
