package globalDatas;

import baseSystem.GlobalStrings;
import classes.Classes;
import dinamicArray.ClassesDinamicArray;
import dinamicArray.DinamicArrays;
import dinamicArray.PersonDinamicArray;
import user.Admin;
import user.Person;
import util.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;


public class GlobalDatas {
    public static final String fileName = "persons.ser";

    public static int id;
    public static Person loggedInPerson = null;
    public static ArrayList<Classes> classesDinamicArray;
    public static ArrayList<Person> personDinamicArray;

    static {

      personDinamicArray = FileUtils.readAll(GlobalStrings.LOG_SAVE_FILE_NAME);
      id = personDinamicArray.size();
      classesDinamicArray = FileUtils.readClassesDinamicArray(GlobalStrings.SAVE_CLASSES_FILE_NAME);
    }
}
