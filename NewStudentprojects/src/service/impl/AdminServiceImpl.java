package service.impl;

import baseSystem.GlobalStrings;
import classes.Classes;
import exception.AppException;
import exception.EnumException;
import globalDatas.GlobalDatas;
import service.AdminServiceInter;
import user.Admin;
import user.Person;
import user.Student;
import user.Teacher;
import util.FileUtils;
import util.Util;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class AdminServiceImpl implements AdminServiceInter {
    @Override
    public void addStudent() {
        String email = Util.requireString("Please insert email: ");
        String password = Util.requireString("Please insert password: ");
        String name = Util.requireString("Please insert name: ");
        String surname = Util.requireString("Please insert surname: ");
        String username = getUsername(name, surname);
        LocalDate birthDay = getBirthDate();
        Student student = new Student(GlobalDatas.id++, email, username, password, name, surname, birthDay);
        GlobalDatas.personDinamicArray.add(student);
        FileUtils.saveAll(GlobalDatas.fileName);
        String log = "Added student with this id: " + GlobalDatas.id + " " + student.getName() + " " + student.getSurname() + "Time: " + LocalDateTime.now();
        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
        System.out.println("Student " + name + " added succesfuly! \n" +
                username + "Password: " + password);
    }

    @Override
    public void addTeacher() {
        try {
            String name = Util.requireString("Please insert name: ");
            String surname = Util.requireString("Please insert surname: ");
            String email = Util.requireString("Please insert email: ");
            String username = getUsername(name, surname);
            String password = Util.requireString("Please insert password: ");
            double salary = Util.requireDouble("Please insert salary: ");
            LocalDate birthDay = getBirthDate();
            Classes classes = getClaases();
            if (classes == null) {
                throw new AppException(EnumException.CLASSES_NOT_FOUND_EXCEPTION);
            }
            Teacher teacher = new Teacher(GlobalDatas.id++, email, username, password, classes, salary, name, surname, birthDay);
            GlobalDatas.personDinamicArray.add(teacher);
            FileUtils.saveAll(GlobalDatas.fileName);
            String log = "Added teacher with this id: " + GlobalDatas.id + " " + teacher.getName() + " " + teacher.getSurname() + "Time: " + LocalDateTime.now();
            FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
            System.out.println("Teacher " + name + " added succesfuly! \n" +
                    username + "Password: " + password);
        }catch (AppException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteUserById(int id) {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {
                    GlobalDatas.personDinamicArray.remove(i);
                    String log = "User deleted with this id: " + id + " " + person.getName() + " " + person.getSurname() + "Time: " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    System.out.println("Student with id " + student.getId() + " has been deleted succesfuly!");
                    return;
                }
            }
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getId() == id) {
                    GlobalDatas.personDinamicArray.remove(i);
                    String log = "User deleted with this id: " + id + " " + person.getName() + " " + person.getSurname() + "Time: " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    System.out.println("Student with id " + teacher.getId() + " has been deleted succesfuly!");
                    return;
                }
            }
        }
    }

    @Override
    public void blockUserById(int id) {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {
                    student.blockStudent();
                    System.out.println("Student with id " + student.getId() + " has been blocked!");
                    Admin admin = (Admin) GlobalDatas.loggedInPerson;
                    String log = "Student with id " + student.getId() + " has been blocked!" + "Time: " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                }
                if (person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getId() == id) {
                        teacher.blockTeacher();
                        System.out.println("Teacher with id " + student.getId() + " has been blocked!");
                        Admin admin = (Admin) GlobalDatas.loggedInPerson;
                        String log = "Teacher blocked with this id: " + id + " " + person.getName() + " " + person.getSurname() + "Time: " + LocalDateTime.now();
                        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);


                    }
                }
            }
        }
    }

    @Override
    public void openBlockById(int id) {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == id) {
                    student.unBlockStudent();
                    String log = "User unblocked with this id: " + id + " " + person.getName() + " " + person.getSurname() + "Time: " + LocalDateTime.now();
                    FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                    System.out.println("Student with id " + student.getId() + " has been unblocked!");
                }
                if (person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getId() == id) {
                        teacher.unBlockTeacher();
                        String log = "User unblocked with this id: " + id + " " + person.getName() + " " + person.getSurname() + "Time: " + LocalDateTime.now();
                        FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);
                        System.out.println("Teacher with id " + student.getId() + " has been unblocked!");
                    }
                }
            }
        }
    }

    @Override
    public void searchUserByName(String name) {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            String lowerName = name.toLowerCase();
            String personName = person.getName().toLowerCase();
            if (personName.contains(lowerName)) {
                System.out.println(person);
            }
        }
    }

    @Override
    public void searchUserById(int id) {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            int lowerId = GlobalDatas.id;
            int personId = person.getId();
            if (personId == GlobalDatas.id) {
                System.out.println(person);
            }
        }
    }

    @Override
    public void changePasswordById(int id) {
        Util.printUserExceptAdmin();
        int userId = Util.requireInt("Please enter users id: ");
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++){
            Person person = GlobalDatas.personDinamicArray.get(i);
            if(person instanceof Student) {
                Student student = (Student) person;
                if (student.getId() == userId) {
                    String newPassword = Util.requireString("Please enter new password: ");
                    student.setPassword(newPassword);
                }
            }
                if(person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getId() == userId) {
                        String newPassword = Util.requireString("Please enter new password: ");
                        teacher.setPassword(newPassword);
                }
            }
        }
    }

    @Override
    public void updateUserById(int id) {

    }

    @Override
    public boolean backToLogin() {
        return true;
    }

    @Override
    public void exit() {
        FileUtils.saveAll(GlobalDatas.fileName);
        System.exit(0);
    }

    private String getUsername(String name, String surname) {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        String username = name.substring(0, 3) + surname.substring(0, 4) + randomNumber;
        return username;
    }

    private LocalDate getBirthDate() {
        int year = Util.requireInt("Please insert birth year: ");
        int month = Util.requireInt("Please insert birth month: ");
        int day = Util.requireInt("Please insert birth day: ");
        return LocalDate.of(year, month, day);
    }

    private Classes getClaases() {
        Util.printClasses();
        String className = Util.requireString("Please insert class name which you want add teacher");
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Classes classes = GlobalDatas.classesDinamicArray.get(i);
            if (classes.getName().equalsIgnoreCase(className)) {
                return classes;
            }
        }
        return null;
    }
}
