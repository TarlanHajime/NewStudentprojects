package baseSystem;

import menuEnums.FirstMenu;
import service.LoginServiceInter;
import service.impl.LoginServiceImpl;
import user.Admin;
import user.Person;
import user.Student;
import user.Teacher;
import util.FileUtils;
import util.Util;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

public class ManagementService {

public static void management() {

    LoginServiceInter loginService = new LoginServiceImpl();
    ManagerSystemInter managerService = new Management();

    while (true) {
        for (FirstMenu menu : FirstMenu.values()) {
            System.out.println("[" + menu.getId() + "]" + "  --->>> " + menu.getOption());
        }
        int option = 0;
        try {
            option = Util.requireInt("Please select option:");
        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        }
        Person loggedInPerson = null;
        switch (option) {
            case 1:
                String username = Util.requireString("Please username: ");
                boolean backToLogin = false;
                loggedInPerson = loginService.login(username);
                String log = "Person logged by name: " + loggedInPerson.getName() + " " + loggedInPerson.getSurname() + " " + "Time: " + LocalDateTime.now().toString();
                FileUtils.writeLogToFile(GlobalStrings.LOG_FILE_NAME, log);

                if (loggedInPerson != null) {
                    if(loggedInPerson instanceof Admin) {
                        System.out.println("Welcome: " + loggedInPerson.getName());
                        while (!backToLogin) {
                            backToLogin = managerService.adminSpecificiation(loggedInPerson);
                        }
                    } else if(loggedInPerson instanceof Teacher) {
                        while (!backToLogin) {
                            System.out.println("Welcome: " + loggedInPerson.getName());
                            backToLogin = managerService.teacherSpecificiation();
                        }
                    } else if(loggedInPerson instanceof Student) {
                        while (!backToLogin) {
                            System.out.println("Welcome: " + loggedInPerson.getName());
                            backToLogin = managerService.studentSpecificiation(loggedInPerson);
                        }
                    }
                }
                break;
            case 0:
                loginService.exit();
                FileUtils.saveAllClasses(GlobalStrings.SAVE_CLASSES_FILE_NAME);
                FileUtils.saveAll(GlobalStrings.LOG_SAVE_FILE_NAME);
                break;
            default:
                System.out.println("Wrong option!!!");
            }
        }
    }
}
