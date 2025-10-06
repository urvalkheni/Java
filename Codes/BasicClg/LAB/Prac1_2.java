import java.util.*;

class StudentPortal {
    private String name;
    private int rollNo;
    private List<Course> courses = new ArrayList<>();

    class Course {
        private String courseName;
        private int semester;

        public Course(String courseName, int semester) {
            this.courseName = courseName;
            this.semester = semester;
        }

        @Override
        public String toString() {
            return courseName + " (Semester " + semester + ")";
        }
    }

    public StudentPortal(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void addCourse(String courseName, int semester) {
        courses.add(new Course(courseName, semester));
    }

    public void checkScholarship(int marks) {
        Scholarship eligibility = new Scholarship() {
            @Override
            public boolean isEligible() {
                return marks >= 90;
            }
        };
        System.out.println("Scholarship Eligibility: " + eligibility.isEligible());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
    if (!(obj instanceof StudentPortal)) return false;
    StudentPortal s = (StudentPortal) obj;
        return rollNo == s.rollNo && Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNo);
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Roll No: " + rollNo + ", Courses: " + courses;
    }

    interface Scholarship {
        boolean isEligible();
    }
}

public class Prac1_2 {
    public static void main(String[] args) {
    StudentPortal s1 = new StudentPortal("Urval", 101);
    StudentPortal s2 = new StudentPortal("Pushti", 102);

        s1.addCourse("Maths", 1);
        s1.addCourse("Physics", 1);
        s2.addCourse("Chemistry", 1);

        System.out.println(s1);
        System.out.println(s2);

        s1.checkScholarship(95);
        s2.checkScholarship(85);

    StudentPortal s3 = new StudentPortal("Urval", 101);
    System.out.println("s1 equals s3? " + s1.equals(s3));

        System.out.println("24CE055<-->Urval Kheni");
    }
}
