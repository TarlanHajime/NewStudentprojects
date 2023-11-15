package util;

import classes.Classes;
import dinamicArray.ClassesDinamicArray;
import dinamicArray.DinamicArrays;
import dinamicArray.PersonDinamicArray;
import globalDatas.GlobalDatas;
import user.Person;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    public static void saveAll(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(GlobalDatas.personDinamicArray);
            objectOutputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Person> readAll(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            ArrayList<Person> personDinamicArray = (ArrayList<Person>) objectInputStream.readObject();
            return personDinamicArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void writeLogToFile(String fileName, String log) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.write(log);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void saveAllClasses(String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(GlobalDatas.classesDinamicArray);
            objectOutputStream.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Classes> readClassesDinamicArray(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            ArrayList<Classes> classesDinamicArray = (ArrayList<Classes>) objectInputStream.readObject();
            return classesDinamicArray;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}