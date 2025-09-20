
/*Single inheritance Student Class(Roll no,name) than Exam Class(sybject 1,subject 2,Subject 3)*/ 
class Student{
    String rollNo;
    String name;

    public Student(String rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void displayStudentInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}
class Exam extends Student {
    String subject1;
    String subject2;
    String subject3;

    public Exam(String rollNo, String name, String subject1, String subject2, String subject3) {
        super(rollNo, name);
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public void displayExamInfo() {
        displayStudentInfo();
        System.out.println("Subject 1: " + subject1);
        System.out.println("Subject 2: " + subject2);
        System.out.println("Subject 3: " + subject3);
    }
}
public class Task2 {
    public static void main(String[] args) {
        Exam exam = new Exam("101", "Urval", "Math", "Science", "English");
        exam.displayExamInfo();
    }
}
