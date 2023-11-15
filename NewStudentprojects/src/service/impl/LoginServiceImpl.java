package service.impl;

import globalDatas.GlobalDatas;
import service.LoginServiceInter;
import user.Admin;
import user.Person;
import user.Student;
import user.Teacher;
import util.Util;

public class LoginServiceImpl implements LoginServiceInter {
    @Override
    public Person login(String username) {
        boolean isFounded = false;

        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Admin) {
                Admin admin = (Admin) person;
                if (admin.getUsername().equals(username)) {
                    isFounded = true;

                    String password = Util.requireString("Please insert password:");
                    if (password.equals(admin.getPassword())) {
                        return admin;
                    }
                }

            } else if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getUsername().equals(username)) {
                    isFounded = true;
                    if (student.isBLocked()) {
                        System.out.println("You have been blocked, please contact with admin");
                        return null;
                    }
                        for (int j = 2; j >= 0; j--) {
                            String password = Util.requireString("Please insert password:");
                            boolean banUser = false;
                            if (password.equals(student.getPassword())) {
                                return student;
                            } else {
                                System.out.println("Wrong password! " + j + " attemps left");
                            }
                            if (j == 0) {
                                student.blockStudent();
                                System.out.println("You have been blocked, please contact with admin");
                                return null;
                            }
                        }
                    }
                } else if (person instanceof Teacher) {
                    Teacher teacher = (Teacher) person;
                    if (teacher.getUsername().equals(username)) {
                        isFounded = true;
                        if (teacher.isBlocked()) {
                            System.out.println("You have been blocked, please contact with admin");
                            return null;
                        }
                            for (int j = 2; j >= 0; j--) {
                                String password = Util.requireString("Please insert password:");
                                boolean banUser = false;
                                if (password.equals(teacher.getPassword())) {
                                    return teacher;
                                } else {
                                    System.out.println("Wrong password! " + j + " attemps left");
                                }
                                if (j == 0) {
                                    teacher.blockTeacher();
                                    System.out.println("You have been blocked, please contact with admin");
                                    return null;
                                }
                            }
                        }
                    }
                }
        if (isFounded == false) {
            System.out.println("Cannot find user with this username!");
        }
        return null;
            }

            @Override
            public void exit () {
                System.out.println("Programm closed good bye!");
                System.exit(0);

            }
        }