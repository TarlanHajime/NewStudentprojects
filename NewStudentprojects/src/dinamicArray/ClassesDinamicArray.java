package dinamicArray;

import classes.Classes;
import user.Person;

import java.io.Serializable;

public class ClassesDinamicArray implements Serializable {

        public Classes[] classes;

        public ClassesDinamicArray() {
            classes = new Classes[0];
        }

        public void add(Classes cls) {
            Classes[] newClasses = new Classes[classes.length + 1];
            for (int i = 0; i < classes.length; i++) {
                newClasses[i] = classes[i];
            }
            newClasses[classes.length] = cls;
            classes = newClasses;
        }

        public void delete(int index) throws IllegalArgumentException {
            if (index < 0 || index >= classes.length) {
                throw new IllegalArgumentException();
            }
            Classes[] newClasses = new Classes[classes.length - 1];

            for (int i = 0, k = 0; i < classes.length; i++) {
                if (i == index) {
                    continue;
                }
                newClasses[k++] = classes[i];
            }
            classes = newClasses;
        }

        public Classes get(int index) {
            if (index < 0 || index >= classes.length) {
                throw new IllegalArgumentException();
            }
            return classes[index];
        }

        public int getSize() {
            return classes.length;
        }
    }
