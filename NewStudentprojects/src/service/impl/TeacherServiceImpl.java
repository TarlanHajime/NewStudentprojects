package service.impl;

import classes.Classes;
import globalDatas.GlobalDatas;
import service.ClassServiceInter;
import service.TeacherServiceInter;
import user.Person;
import user.Student;

public class TeacherServiceImpl implements TeacherServiceInter {

    private ClassServiceInter classService = new ClassesService();

    @Override
    public void seeAllStudents() {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student.getDetailsForTeacher());
            }
        }
    }

    @Override
    public void seeAllClasses() {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Classes classes = GlobalDatas.classesDinamicArray.get(i);
            System.out.println(classes.getName());
            for (int j = 0; j < classes.getStudentsDinamicArray().getSize(); j++) {
                Student student = (Student) classes.getStudentsDinamicArray().get(j);
                System.out.println(student);
            }
        }
    }

    @Override
    public void addStudentToClasses() {
        classService.addStudentToClass();

    }

    @Override
    public boolean backToLogin() {
        return true;
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
