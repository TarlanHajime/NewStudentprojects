package util;

import globalDatas.GlobalDatas;
import user.Person;
import user.Student;
import user.Teacher;
import java.util.Scanner;

public class Util {
    public static int requireInt(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        int result = sc.nextInt();
        return result;
    }

    public static String requireString(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        String result = sc.nextLine();
        return result;
    }

    public static double requireDouble(String title) {
        Scanner sc = new Scanner(System.in);
        System.out.println(title + ":");
        double result = sc.nextDouble();
        return result;
    }
    public static boolean printUserExceptAdmin() {
        boolean isFounded = false;
        for(int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if(person instanceof Student) {
            Student student = (Student) person;
            isFounded = true;
                System.out.println(student);
            }
            if (person instanceof Teacher) {
                isFounded = true;
                Teacher teacher = (Teacher) person;
                System.out.println(teacher);
            }
        }
        return isFounded;
    }
    public static boolean printStudents() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                isFounded = true;
                System.out.println(student);
            }
        }
        return isFounded;
    }
    public static boolean printUnBlockUsersExceptions() {
        boolean isFounded = false;
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            Person person = GlobalDatas.personDinamicArray.get(i);
            if (person instanceof Student) {
                Student student = (Student) person;
                if (!student.isBLocked()) {
                    isFounded = true;
                    System.out.println(student);
                }
            }
            if (person instanceof Teacher) {
                isFounded = true;
                Teacher teacher = (Teacher) person;
                if (!teacher.isBlocked()) {
                    System.out.println(teacher);
                }
            }
        }
        return isFounded;
    }
    public static void printClasses() {
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            System.out.println(GlobalDatas.classesDinamicArray.toString());
        }
    }
}
