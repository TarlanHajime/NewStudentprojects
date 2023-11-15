package baseSystem;

import exception.AppException;
import exception.EnumException;
import globalDatas.GlobalDatas;
import menuEnums.AdminMenu;
import menuEnums.StudentMenu;
import menuEnums.TeacherMenu;
import service.AdminServiceInter;
import service.StudentServiceInter;
import service.TeacherServiceInter;
import service.impl.AdminServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;
import user.Person;
import util.FileUtils;
import util.Util;

public class Management implements ManagerSystemInter {

    AdminServiceInter adminService = new AdminServiceImpl();
    StudentServiceInter studentService = new StudentServiceImpl();
    TeacherServiceInter teacherService = new TeacherServiceImpl();

    @Override
    public boolean adminSpecificiation(Person loggedInPerson) {
        printmenuForAdmin();
        boolean backToLogin = false;

        int option = Util.requireInt("Please insert option: ");
        int id = 0;
        boolean isTeacherorStudentValid = true;
        switch (option) {
            case 1:
                adminService.addStudent();
                break;
            case 2:
                adminService.addTeacher();
                break;
            case 3:
                isTeacherorStudentValid = Util.printStudents();
                try {
                    if (!isTeacherorStudentValid) {
                        throw new AppException(EnumException.USER_NOT_FOUND_EXCEPTION);
                    }
                        int userId = Util.requireInt("Please insert users id, which you want to delete: ");
                        adminService.deleteUserById(userId);
                }catch (AppException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 4:
                adminService.updateUserById(id);
                break;
            case 5:
                isTeacherorStudentValid = Util.printUnBlockUsersExceptions();
                if (isTeacherorStudentValid) {
                    int userId = Util.requireInt("Please insert users id, which you want to block: ");
                    adminService.blockUserById(id);
                } else {
                    System.out.println("There is not students or teachers in system");
                }
                break;
            case 6:
                isTeacherorStudentValid = Util.printStudents();
                if (isTeacherorStudentValid) {
                    int userId = Util.requireInt("Please insert users id, which you want to open block: ");
                    adminService.openBlockById(id);
                } else {
                    System.out.println("There is not students or teachers in system");
                }
                break;
            case 7:
                String name = Util.requireString("Please insert name for search: ");
                adminService.searchUserByName(name);
                break;
            case 8:
                adminService.changePasswordById(id);
                break;
            case 9:
                int searchId = Util.requireInt("Please insert id for search: ");
                adminService.searchUserById(id);
                break;
            case 10:
                backToLogin = adminService.backToLogin();
                return backToLogin;
            case 0:
                FileUtils.saveAll("persons.ser");
                adminService.exit();
                break;
            default:
        }
        for (int i = 0; i < GlobalDatas.personDinamicArray.size(); i++) {
            System.out.println(GlobalDatas.personDinamicArray.get(i).getName() + " " + GlobalDatas.personDinamicArray.get(i).getBirthday());
        }
        return backToLogin;
    }

    @Override
    public boolean teacherSpecificiation() {
        printTeacherMenu();
        int option = Util.requireInt("Please insert option: ");

        switch (option) {
            case 1 : teacherService.seeAllClasses();
                break;
            case 2 : teacherService.seeAllClasses();
                break;
            case 3 : teacherService.addStudentToClasses();
                break;
            case 4 : return teacherService.backToLogin();
            case 0 : teacherService.exit();
                break;
                default:
                    System.out.println("Wrong input!!");
        }
        return false;
    }

    @Override
    public boolean studentSpecificiation(Person loggedInPerson) {
        printMenuForStudent();
        int option = Util.requireInt("Please insert option: ");

        switch (option) {
            case 1 : studentService.seeOwnInfo(loggedInPerson);
            break;
            case 2 : studentService.resetPassword(loggedInPerson);
            break;
            case 3 : studentService.backToLogin();
            break;
            case 4 : return studentService.backToLogin();
            case 0 : studentService.exit();
            break;
            default:
                System.out.println("Wrong option!!");
        }
        return true;
    }

    public void printmenuForAdmin() {
        for (AdminMenu adminMenu : AdminMenu.values()) {
            System.out.println("[" + adminMenu.getId() + "]" + "  --->>> " + adminMenu.getOption());
        }
    }

    private void printMenuForStudent() {
        for (StudentMenu studentMenu : StudentMenu.values()) {
            System.out.println("[" + studentMenu.getId() + "]" + "  --->>> " + studentMenu.getOption());
        }
    }

    private void printTeacherMenu() {
        for(TeacherMenu teacherMenu : TeacherMenu.values()) {
            System.out.println("[" + teacherMenu.getId() + "]" + "  --->>> " + teacherMenu.getOption());
        }
    }
}
