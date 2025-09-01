package Codes.BasicClg.LAB.Practicallist.Prac3_3.student.details;

public class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }

    // Display details
    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}
