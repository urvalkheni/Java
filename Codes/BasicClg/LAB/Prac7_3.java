import java.util.*;

public class Prac7_3 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n--- Student ID Management ---");
            System.out.println("1. Add Student ID");
            System.out.println("2. Remove Student ID");
            System.out.println("3. Check Student ID");
            System.out.println("4. Display IDs");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID to add: ");
                    String id = sc.nextLine();
                    if (hashSet.add(id)) {
                        treeSet.add(id);
                        linkedHashSet.add(id);
                        System.out.println("Student ID added successfully.");
                    } else {
                        System.out.println("ID already exists.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter Student ID to remove: ");
                    String id = sc.nextLine();
                    if (hashSet.remove(id)) {
                        treeSet.remove(id);
                        linkedHashSet.remove(id);
                        System.out.println("Student ID removed successfully.");
                    } else {
                        System.out.println("ID not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Student ID to check: ");
                    String id = sc.nextLine();
                    System.out.println("Exists? " + hashSet.contains(id));
                }
                case 4 -> {
                    System.out.println("\nHashSet (Unordered): " + hashSet);
                    System.out.println("TreeSet (Sorted): " + treeSet);
                    System.out.println("LinkedHashSet (Insertion order): " + linkedHashSet);
                }
                case 5 -> System.out.println("Exiting Student ID Management.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        System.out.println("24CE055<-->Urval Kheni");
    }
}
