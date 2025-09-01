
package Codes.BasicClg.LAB.Practicallist.Prac3_3;
import Codes.BasicClg.LAB.Practicallist.Prac3_3.student.details.Student;
import Codes.BasicClg.LAB.Practicallist.Prac3_3.student.services.StudentService;

public class MainApp {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        // Create sample students
        Student s1 = new Student("S101", "Urval", 19, 85);
        Student s2 = new Student("S102", "Heet", 20, 92);
        Student s3 = new Student("X200", "Krish", 18, 45); // Invalid ID

        // Register them
        service.registerStudent(s1);
        service.registerStudent(s2);
        service.registerStudent(s3);

        // List all students
        System.out.println("\n=== All Students ===");
        service.listStudents();

        // Search student by ID
        System.out.println("\n=== Search Result ===");
        service.searchById("S101");
    }
}
