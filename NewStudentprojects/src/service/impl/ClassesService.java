package service.impl;

import baseSystem.GlobalStrings;
import classes.Classes;
import globalDatas.GlobalDatas;
import service.ClassServiceInter;
import user.Person;
import user.Student;
import util.FileUtils;
import util.Util;

import java.time.LocalDateTime;

public class ClassesService implements ClassServiceInter {
    @Override
    public void addStudentToClass() {

        Util.printStudents();
        int studentId = Util.requireInt("Please enter student id which you want to add to class");
        Student selectedStudent = getStudentId(studentId);

        Util.printClasses();
        String selectedClassName = Util.requireString("Please enter class name which you want to add to student");
        Classes selectedClasses = null;
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Classes classes = GlobalDatas.classesDinamicArray.get(i);
            if(classes.getName().equalsIgnoreCase(selectedClassName)) {
                selectedClasses = classes;

            }
        }
        selectedClasses.getStudentsDinamicArray().add(selectedStudent);
        System.out.println("Student: " + selectedStudent.getName() + "added to new class " + selectedClasses.getName());
        String log = "Student: " + selectedStudent.getName() + "added to new class " + selectedClasses.getName() + "Time: " + LocalDateTime.now();
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);


    }

    private Student getStudentId(int id) {
        Student student = null;
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student selectedStudent = (Student) person;
                if (selectedStudent.getId() == id) {
                    student = selectedStudent;
                    return student;
                }
            }
        }
        return student;
    }
    }
