package service;

import user.Person;

public interface LoginServiceInter {

    Person login(String password);

    void exit();

}
