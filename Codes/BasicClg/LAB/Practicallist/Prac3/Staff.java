package Codes.BasicClg.LAB.Practicallist.Prac3;

public class Staff {
    protected String name;
    protected int id;
    protected String department;
    protected double salary;
    
    // Constructor chaining using this()
    public Staff() {
        this("Unknown", 0, "General", 0.0);
    }
    
    public Staff(String name, int id) {
        this(name, id, "General", 0.0);
    }
    
    public Staff(String name, int id, String department) {
        this(name, id, department, 0.0);
    }
    
    public Staff(String name, int id, String department, double salary) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.salary = salary;
    }
    
    // Method to be overridden by subclasses
    public void work() {
        System.out.println(name + " (ID: " + id + ") is performing general duties in " + department);
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
    
    // Getters and setters
    public String getName() { return name; }
    public int getId() { return id; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}
