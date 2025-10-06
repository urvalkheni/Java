import java.util.ArrayList;
import java.util.Scanner;

public class Prac7_1 {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> displayTasks();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting To-Do List.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        System.out.println("24CE055<-->Urval Kheni");
    }

    static void addTask() {
        System.out.print("Enter task to add: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n--- Tasks ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    static void editTask() {
        displayTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to edit: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if (index >= 0 && index < tasks.size()) {
            System.out.print("Enter new task: ");
            String newTask = sc.nextLine();
            tasks.set(index, newTask);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void deleteTask() {
        displayTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
