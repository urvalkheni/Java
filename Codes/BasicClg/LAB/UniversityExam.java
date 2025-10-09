
import java.util.Scanner;

class InvalidMarks extends Exception {

    public InvalidMarks(String message) {
        super(message);
    }
}

interface Grades {

    double calculatePercentage();

    char grade();
}

class Student {

    protected String rollNumber;
    protected String name;
    protected int[] marks = new int[3];

    public Student(String rollNumber, String name, int[] marks) throws InvalidMarks {
        this.rollNumber = rollNumber;
        this.name = name;
        setMarks(marks);
    }

    public void setMarks(int[] marks) throws InvalidMarks {
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarks("Marks in Range 0 and 100.");
            }
        }
        this.marks = marks;
    }
}

class Undergraduate extends Student implements Grades {

    public Undergraduate(String rollNumber, String name, int[] marks) throws InvalidMarks {
        super(rollNumber, name, marks);
    }

    public double calculatePercentage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / 3.0;
    }

    public char grade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return 'A'; 
        }else if (percentage >= 75) {
            return 'B'; 
        }else if (percentage >= 60) {
            return 'C'; 
        }else if (percentage >= 50) {
            return 'D'; 
        }else {
            return 'F';
        }
    }
}

class Postgraduate extends Student implements Grades {

    public Postgraduate(String rollNumber, String name, int[] marks) throws InvalidMarks {
        super(rollNumber, name, marks);
    }

    public double calculatePercentage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / 3.0;
    }

    public char grade() {
        double percentage = calculatePercentage();
        if (percentage >= 95) {
            return 'A'; 
        }else if (percentage >= 85) {
            return 'B'; 
        }else if (percentage >= 70) {
            return 'C'; 
        }else if (percentage >= 60) {
            return 'D'; 
        }else {
            return 'F';
        }
    }
}

public class UniversityExam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.print("Enter student type (U for Undergraduate, P for Postgraduate) :: ");
            char type = sc.next().toUpperCase().charAt(0);
            sc.nextLine();
            System.out.print("Enter roll number :: ");
            String rollNumber = sc.nextLine();
            System.out.print("Enter name :: ");
            String name = sc.nextLine();
            int[] marks = new int[3];
            System.out.println("Enter marks for 3 subjects ::");
            for (int i = 0; i < 3; i++) {
                System.out.print("Subject " + (i + 1) + " :: ");
                marks[i] = sc.nextInt();
            }
            Grades student;
            if (type == 'U') {
                student = new Undergraduate(rollNumber, name, marks);
            } else if (type == 'P') {
                student = new Postgraduate(rollNumber, name, marks);
            } else {
                System.out.println("Invalid student type.");
                return;
            }
            System.out.printf("Percentage :: %.2f", student.calculatePercentage());
            System.out.println("");
            System.out.println("Grade :: " + student.grade());
        } catch (InvalidMarks e) {
            System.out.println("Error :: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error :: Invalid input.");
        } finally {
            System.out.println("Result processed");
            sc.close();
        }
    }
}