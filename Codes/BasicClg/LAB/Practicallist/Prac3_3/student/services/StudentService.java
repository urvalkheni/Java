
package Codes.BasicClg.LAB.Practicallist.Prac3_3.student.services;
import Codes.BasicClg.LAB.Practicallist.Prac3_3.student.details.Student;
import Codes.BasicClg.LAB.Practicallist.Prac3_3.student.utility.Utility;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    // Register a student
    public void registerStudent(Student s) {
        if (Utility.validateId(s.getId())) {
            students.add(s);
            System.out.println(" Student " + s.getName() + " registered successfully!");
        } else {
            System.out.println(" Invalid Student ID: " + s.getId());
        }
    }

    // List all students
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : students) {
            s.displayStudent();
            System.out.println("Grade: " + Utility.calculateGrade(s.getMarks()));
            System.out.println("---------------------");
        }
    }

    // Search student by ID
    public void searchById(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.displayStudent();
                System.out.println("Grade: " + Utility.calculateGrade(s.getMarks()));
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
