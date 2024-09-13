import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private static ArrayList<String> todoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== To-Do List App ===");
            System.out.println("1. View To-Do List");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewTodoList();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    System.out.println("Exiting the app.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void viewTodoList() {
        if (todoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("Your to-do list:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added.");
    }

    private static void removeTask() {
        if (todoList.isEmpty()) {
            System.out.println("No tasks to remove.");
        } else {
            System.out.print("Enter the task number to remove: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (taskNumber > 0 && taskNumber <= todoList.size()) {
                todoList.remove(taskNumber - 1);
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
