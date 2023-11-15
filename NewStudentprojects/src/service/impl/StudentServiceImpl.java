package service.impl;

import service.StudentServiceInter;
import user.Person;
import user.Student;
import util.Util;

public class StudentServiceImpl implements StudentServiceInter {
    @Override
    public void seeOwnInfo(Person person) {

        Student student = (Student) person;
        System.out.println(student);

    }

    @Override
    public void resetPassword(Person person) {

        Student student = (Student) person;
        String oldPassword = Util.requireString("Please insert old password: ");

        if (oldPassword.equals(student.getPassword())) {
            String newPassword = Util.requireString("Please insert new password: ");
            student.setPassword(newPassword);
            System.out.println("Password has been changed!");
        } else {
            return;
        }
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
