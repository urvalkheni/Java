class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private static int employeeCount = 0;

    public Employee() {
        this(0, "Unknown", "None", 0.0);
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        employeeCount++;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
}

class PermanentEmployee extends Employee {
    public PermanentEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
    }
}

public class Prac1_1 {
    public static void main(String[] args) {
        Employee e1 = new PermanentEmployee(101, "Urval", "IT", 50000);
        Employee e2 = new ContractEmployee(102, "Pushti", "HR", 30000);
        Employee e3 = new Employee();

        e1.display();
        e2.display();
        e3.display();

        System.out.println("\nTotal Employees: " + Employee.getEmployeeCount());

        if (e1 instanceof PermanentEmployee) {
            System.out.println(e1.getClass().getSimpleName() + " is a Permanent Employee");
        }
        if (e2 instanceof ContractEmployee) {
            System.out.println(e2.getClass().getSimpleName() + " is a Contract Employee");
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
