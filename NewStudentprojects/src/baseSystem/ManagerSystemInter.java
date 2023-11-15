package baseSystem;

import user.Person;

public interface ManagerSystemInter {

    boolean adminSpecificiation(Person person);
    boolean teacherSpecificiation();
    boolean studentSpecificiation(Person person);
}
