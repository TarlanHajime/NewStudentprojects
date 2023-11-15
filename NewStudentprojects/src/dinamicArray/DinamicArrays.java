package dinamicArray;

import java.io.Serializable;

public class DinamicArrays <T> implements Serializable {
    private Object[] array;

    public DinamicArrays() {

        array = new Object[0];
    }

    public void add(T person) {
        Object[] newPersons = new Object[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newPersons[i] = array[i];
        }
        newPersons[array.length] = person;
        array = newPersons;
    }

    public void delete(int index) throws IllegalArgumentException {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException();
        }
        Object[] newPersons = new Object[array.length - 1];

        for (int i = 0, k =0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            newPersons[k++] = array[i];
        }
        array = newPersons;
    }

    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException();
        }
        return (T)array[index];
    }

    public int getSize() {
        return array.length;
    }
}