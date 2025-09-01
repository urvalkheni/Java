
package Codes.BasicClg.LAB.Practicallist.Prac3_3.student.utility;

public class Utility {
    // Calculate grade
    public static String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    // Validate Student ID (must start with 'S' followed by digits)
    public static boolean validateId(String id) {
        return id != null && id.matches("S[0-9]+");
    }
}
