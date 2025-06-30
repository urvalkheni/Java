package Codes.BasicClg.LAB;

public class Admin {
    public static void main(String[] args) {
        Display display = new Display();
        display.show();
        Sum sum = new Sum();
        int result = sum.add(5, 10);
        System.out.println("Sum: " + result);
        Student student = new Student("Kheni Urval",18,"12345");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student ID: " + student.getStudentId());
    }
}
// This class demonstrates the use of Display and Sum classes.
// It creates instances of both classes and calls their methods.
// How To Run java Code without main method and from which version it was restricted