package service;

import user.Person;

public interface StudentServiceInter {

    void seeOwnInfo(Person person);
    void resetPassword(Person person);
    boolean backToLogin();
    void exit();
}
