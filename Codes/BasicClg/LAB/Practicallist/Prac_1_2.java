package Codes.BasicClg.LAB.Practicallist;

class Student {
    public String id;
    public String name;
    public String branch;
    public float cgpa;

    public Student() {}

    public Student(String id, String name, String branch, float cgpa) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    // Inner class for Course
    class Course {
        private String courseName;
        private String courseCode;

        public Course(String courseName, String courseCode) {
            this.courseName = courseName;
            this.courseCode = courseCode;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getCourseCode() {
            return courseCode;
        }
    }

    // Inner class for Scholarship
    class Scholarship {
        private String scholarshipName;
        private float amount;

        public Scholarship(String scholarshipName, float amount) {
            this.scholarshipName = scholarshipName;
            this.amount = amount;
        }

        public String getScholarshipName() {
            return scholarshipName;
        }

        public float getAmount() {
            return amount;
        }
    }
}

public class Prac_1_2 {
    public static void main(String[] args) {
        Student student1 = new Student("123", "Urval", "Computer Engineering", 9.8f);
        Student student2 = new Student("456", "Aarav", "Information Technology", 9.6f);
        System.out.println();
        // Creating course and scholarship for student1 and 
        Student.Course course1 = student1.new Course("Java Programming", "CS101");
        Student.Scholarship scholarship1 = student1.new Scholarship("Merit Scholarship", 10000.0f);
        System.out.println("Student 1 Details:");
        System.out.println("ID: " + student1.id);
        System.out.println("Name: " + student1.name);
        System.out.println("Branch: " + student1.branch);
        System.out.println("CGPA: " + student1.cgpa);
        System.out.println();
        System.out.println("Student 2 Details:");
        System.out.println("ID: " + student2.id);
        System.out.println("Name: " + student2.name);
        System.out.println("Branch: " + student2.branch);
        System.out.println("CGPA: " + student2.cgpa);
        System.out.println();
        System.out.println("Course Details for Student 1:");
        System.out.println("Course Name: " + course1.getCourseName());
        System.out.println("Course Code: " + course1.getCourseCode());
        System.out.println("Scholarship Details for Student 1:");
        System.out.println("Scholarship Name: " + scholarship1.getScholarshipName());
        System.out.println("Scholarship Amount: " + scholarship1.getAmount());
        System.out.println();
        // Creating course and scholarship for student2
        Student.Course course2 = student2.new Course("Data Structures", "IT202");
        Student.Scholarship scholarship2 = student2.new Scholarship("Excellence Scholarship", 15000.0f);
        System.out.println("Course Details for Student 2:");
        System.out.println("Course Name: " + course2.getCourseName());
        System.out.println("Course Code: " + course2.getCourseCode());
        System.out.println("Scholarship Details for Student 2:");
        System.out.println("Scholarship Name: " + scholarship2.getScholarshipName());
        System.out.println("Scholarship Amount: " + scholarship2.getAmount());
        System.out.println();
        System.out.println("End of Student Details");       
    }
}
