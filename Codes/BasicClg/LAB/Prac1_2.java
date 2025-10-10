import java.util.*;

class StudentPortal {
    private String name;
    private int rollNo;
    private List<Course> courses = new ArrayList<>();
    private double cgpa;

    class Course {
        private String courseName;
        private int semester;
        private int credits;
        private double grade;

        public Course(String courseName, int semester) {
            this(courseName, semester, 3, 0.0);
        }
        
        public Course(String courseName, int semester, int credits, double grade) {
            this.courseName = courseName;
            this.semester = semester;
            this.credits = credits;
            this.grade = grade;
        }
        
        public double getGradePoints() {
            return grade * credits;
        }

        @Override
        public String toString() {
            return String.format("%s (Sem %d, Credits: %d, Grade: %.2f)", 
                               courseName, semester, credits, grade);
        }
        
        // Getters
        public String getCourseName() { return courseName; }
        public int getSemester() { return semester; }
        public int getCredits() { return credits; }
        public double getGrade() { return grade; }
    }

    public StudentPortal(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.cgpa = 0.0;
    }

    public void addCourse(String courseName, int semester) {
        addCourse(courseName, semester, 3, 0.0);
    }
    
    public void addCourse(String courseName, int semester, int credits, double grade) {
        courses.add(new Course(courseName, semester, credits, grade));
        calculateCGPA();
    }
    
    private void calculateCGPA() {
        if (courses.isEmpty()) {
            cgpa = 0.0;
            return;
        }
        
        double totalGradePoints = 0;
        int totalCredits = 0;
        
        for (Course course : courses) {
            totalGradePoints += course.getGradePoints();
            totalCredits += course.getCredits();
        }
        
        cgpa = totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }

    public void checkScholarship(int marks) {
        Scholarship eligibility = new Scholarship() {
            @Override
            public boolean isEligible() {
                return marks >= 90 || cgpa >= 9.0;
            }
        };
        System.out.printf("Scholarship Eligibility for %s (Marks: %d, CGPA: %.2f): %s%n", 
                         name, marks, cgpa, eligibility.isEligible() ? "ELIGIBLE" : "NOT ELIGIBLE");
    }
    
    public double getCGPA() {
        return cgpa;
    }
    
    public int getTotalCredits() {
        return courses.stream().mapToInt(Course::getCredits).sum();
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
        return String.format("Student: %s, Roll No: %d, CGPA: %.2f, Total Credits: %d%nCourses: %s", 
                           name, rollNo, cgpa, getTotalCredits(), courses);
    }

    interface Scholarship {
        boolean isEligible();
    }
}

public class Prac1_2 {
    public static void main(String[] args) {
        System.out.println("=== Student Portal Management System ===\n");
        
        StudentPortal s1 = new StudentPortal("Urval", 101);
        StudentPortal s2 = new StudentPortal("Pushti", 102);

        // Add courses with grades
        s1.addCourse("Mathematics", 1, 4, 9.5);
        s1.addCourse("Physics", 1, 3, 8.7);
        s1.addCourse("Programming", 2, 4, 9.8);
        
        s2.addCourse("Chemistry", 1, 3, 8.2);
        s2.addCourse("Biology", 1, 4, 7.8);

        System.out.println("Student Information:");
        System.out.println("=".repeat(80));
        System.out.println(s1);
        System.out.println("\n" + s2);

        System.out.println("\n" + "=".repeat(80));
        System.out.println("Scholarship Check:");
        s1.checkScholarship(95);
        s2.checkScholarship(85);

        StudentPortal s3 = new StudentPortal("Urval", 101);
        System.out.println("\nEquality Check:");
        System.out.println("s1 equals s3? " + s1.equals(s3));
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s3 hashCode: " + s3.hashCode());

        System.out.println("\n24CE055 <--> Urval Kheni");
    }
}
