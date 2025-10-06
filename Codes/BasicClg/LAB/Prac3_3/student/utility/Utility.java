package student.utility;

public class Utility {
    public static String calculateGrade(double marks) {
        if (marks >= 85) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }
}
