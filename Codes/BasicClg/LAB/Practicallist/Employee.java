package Codes.BasicClg.LAB.Practicallist;
public class Employee {

    private int id;
    private String name;
    private String department;
    private float salary;
    public Employee(){}
   
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public float getSalary() {
        return salary;
    }
    public Employee(int id, String name, String department, float salary) {
        this();
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

}
