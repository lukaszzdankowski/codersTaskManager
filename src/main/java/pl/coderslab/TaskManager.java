package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    static String[][] tasks;

    public static void main(String[] args) {
        tasks = loadDataToTab(FILE_NAME);
        printOptions(OPTIONS);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    break;
                case "add":
                    break;
                case "remove":
                    break;
                case "list":
                    printTab(tasks);
                    break;
                default:
                    System.out.println("Please select a correct option.");
            }
            printOptions(OPTIONS);
        }
    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option: "
                + ConsoleColors.RESET);
        for (String option : tab) {
            System.out.println(option);
        }
    }

    public static String[][] loadDataToTab(String fileName) {
        Path file = Paths.get(fileName);
        if (!Files.exists(file)) {
            System.out.println("File not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(file);
            tab = new String[strings.size()][strings.get(0).split(",").length];
            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR in readAllLines");
        }
        return tab;
    }

    public static void printTab(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }


}
