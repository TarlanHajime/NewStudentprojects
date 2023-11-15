package dinamicArray;

import user.Person;

import java.io.Serializable;

public class PersonDinamicArray implements Serializable {

    private Person[] persons;

    public PersonDinamicArray() {

        persons = new Person[0];
    }

    public void add(Person person) {
        Person[] newPersons = new Person[persons.length + 1];

        for (int i = 0; i < persons.length; i++) {
            newPersons[i] = persons[i];
        }
        newPersons[persons.length] = person;
        persons = newPersons;
    }

    public void delete(int index) throws IllegalArgumentException {
        if (index < 0 || index >= persons.length) {
            throw new IllegalArgumentException();
        }
            Person[] newPersons = new Person[persons.length - 1];

            for (int i = 0, k =0; i < persons.length; i++) {
                if (i == index) {
                    continue;
                }
                newPersons[k++] = persons[i];
            }
            persons = newPersons;
        }

        public Person get(int index) {
        if (index < 0 || index >= persons.length) {
            throw new IllegalArgumentException();
        }
        return persons[index];
        }

        public int getSize() {
            return persons.length;
        }
    }

