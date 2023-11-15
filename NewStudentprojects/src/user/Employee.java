package user;

import java.time.LocalDate;

public abstract class Employee extends Person {

    private double salary;

    public Employee(double salary, String name, String surname, LocalDate birthday) {
        super(name, surname, birthday);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
