package menuEnums;

public enum AdminMenu {
    ADD_STUDENT(1, "Add student"),
    ADD_TEACHER(2, "Add teacher"),
    DELETE_USER_BY_ID(3, "Delete user by ID"),
    UPDATE_USER_BY_ID(4, "Update user by ID"),
    BLOCK_STUDENT_BY_ID(5, "Block student by ID"),
    OPEN_BLOCK_BY_ID(6, "Open block by ID"),
    SEARCH_USER_BY_NAME(7, "Search user by name"),
    CHANGE_PASSWORD(8, "Change password"),
    SEARCH_USER_BY_ID(9, "Search user by ID"),
    BACK_TO_LOGIN(10, "Back to login"),
    EXIT(0, "Exit!");


    private int id;
    private String option;

    AdminMenu(int id, String option) {
        this.id = id;
        this.option = option;
   }

    public int getId() {
        return id;
    }
    public String getOption() {
        return option;
    }
}
