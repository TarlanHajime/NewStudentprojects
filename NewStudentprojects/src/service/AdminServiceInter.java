package service;

public interface AdminServiceInter {

    void addStudent();
    void addTeacher();
    void deleteUserById(int id);
    void updateUserById(int id);
    void blockUserById(int id);
    void openBlockById(int id);
    void searchUserByName(String name);
    void changePasswordById(int id);
    void searchUserById(int id);
    boolean backToLogin();
    void exit();

}
