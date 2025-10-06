import student.details.Student;
import student.services.StudentService;

public class Main3_3{
    public static void main(String[] args) {
        StudentService service = new StudentService();

        Student s1 = new Student(1, "Disu", 92);
        Student s2 = new Student(2, "Aryan", 75);
        Student s3 = new Student(3, "Om", 48);

        service.registerStudent(s1);
        service.registerStudent(s2);
        service.registerStudent(s3);

        System.out.println("\n--- All Students ---");
        service.showAll();

        System.out.println("\n--- Searching by ID 2 ---");
        service.searchById(2);
        System.out.println("24CE055<-->Urval Kheni");
    }
}
