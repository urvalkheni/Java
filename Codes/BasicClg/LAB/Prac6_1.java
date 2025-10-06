// Prac6_1.java
// Reads student marks from file and generates grade reports

import java.io.*;

class Student {
    String name;
    int[] marks;
    double average;
    String grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.average = calculateAverage();
        this.grade = assignGrade();
    }

    private double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / (double) marks.length;
    }

    private String assignGrade() {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }

    public void printReport() {
        System.out.println("Name: " + name + " | Average: " + average + " | Grade: " + grade);
    }
}

public class Prac6_1 {
    public static void main(String[] args) {
        String inputFile = "students.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            System.out.println("---- Grade Report ----");
            while ((line = br.readLine()) != null) {
                // Example line: Urval 85 90 78 88 92
                String[] parts = line.split(" ");
                String name = parts[0];
                int[] marks = new int[parts.length - 1];
                for (int i = 1; i < parts.length; i++) marks[i - 1] = Integer.parseInt(parts[i]);
                Student s = new Student(name, marks);
                s.printReport();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
