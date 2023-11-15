package classes;

import dinamicArray.PersonDinamicArray;

import java.io.Serializable;

public class Classes implements Serializable {
    private String name;
    private PersonDinamicArray studentsDinamicArray;

    public Classes() {
    }

    public Classes(String name, PersonDinamicArray studentsDinamicArray) {
        this.name = name;
        this.studentsDinamicArray = studentsDinamicArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonDinamicArray getStudentsDinamicArray() {
        return studentsDinamicArray;
    }

    public void setStudentsDinamicArray(PersonDinamicArray studentsDinamicArray) {
        this.studentsDinamicArray = studentsDinamicArray;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", studentsDinamicArray=" + studentsDinamicArray +
                '}';
    }
}
