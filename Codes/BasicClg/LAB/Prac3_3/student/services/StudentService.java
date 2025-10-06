package student.services;

import student.details.Student;
import student.utility.Utility;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> list = new ArrayList<>();

    public void registerStudent(Student s) {
        list.add(s);
        System.out.println(s.getName() + " registered successfully!");
    }

    public void showAll() {
        for (Student s : list) {
            s.displayInfo();
            System.out.println("Grade: " + Utility.calculateGrade(s.getMarks()));
            System.out.println("-----------------------------");
        }
    }

    public void searchById(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
