package pl.coderslab;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    static String[][] tasks;

    public static void main(String[] args) {
        printOptions(OPTIONS);

    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option: "
                + ConsoleColors.RESET);
        for (String option : tab) {
            System.out.println(option);
        }
    }


}
