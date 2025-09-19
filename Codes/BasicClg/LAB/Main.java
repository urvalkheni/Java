package Codes.BasicClg.LAB;

public class Main {
    public static void main(String[] args){
        System.out.println("=== Testing Constructor Chaining ===");
        
        // Testing Institute class constructor chaining
        System.out.println("\n=== Institute Constructor Chaining ===");
    Institute inst1 = new Institute();
    Institute inst2 = new Institute(101);
    Institute inst3 = new Institute(102, "CSPIT");
    // Use the variables to avoid warnings
    System.out.println(inst1);
    System.out.println(inst2);
    System.out.println(inst3);
        
        // Testing Student1 class constructor chaining
        System.out.println("\n=== Student1 Constructor Chaining ===");
        System.out.println("\n1. Creating Student1 with default constructor:");
        Student1 student1 = new Student1();
        student1.displayStudent();
        
        // Testing Faculty class constructor chaining
        System.out.println("\n=== Faculty Constructor Chaining ===");
        System.out.println("\n1. Creating Faculty with default constructor:");
        Faculty faculty1 = new Faculty();
        faculty1.displayFaculty();
        
    }
}
