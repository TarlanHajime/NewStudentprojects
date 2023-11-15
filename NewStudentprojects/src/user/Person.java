package user;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {

    protected String name;
    protected String surname;
    protected LocalDate birthday;
    protected int id;

    public Person(String name, String surname, LocalDate birthday) {

        this.name = name;
        this.surname = surname;
        this.birthday = birthday;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
