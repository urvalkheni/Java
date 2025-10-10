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
        if (id < 0) throw new IllegalArgumentException("ID cannot be negative");
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative");
        
        this.id = id;
        this.name = name != null ? name : "Unknown";
        this.department = department != null ? department : "None";
        this.salary = salary;
        employeeCount++;
    }

    public void display() {
        System.out.printf("ID: %d, Name: %-15s, Department: %-10s, Salary: $%.2f%n", 
                         id, name, department, salary);
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
    
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    // Setters with validation
    public void setSalary(double salary) {
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative");
        this.salary = salary;
    }
}

class PermanentEmployee extends Employee {
    private double bonus;
    
    public PermanentEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
        this.bonus = salary * 0.1; // 10% bonus
    }
    
    public PermanentEmployee(int id, String name, String department, double salary, double bonus) {
        super(id, name, department, salary);
        this.bonus = bonus;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.printf("Bonus: $%.2f, Total: $%.2f%n", bonus, getSalary() + bonus);
    }
    
    public double getBonus() { return bonus; }
}

class ContractEmployee extends Employee {
    private int contractDurationMonths;
    
    public ContractEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
        this.contractDurationMonths = 12; // Default 1 year
    }
    
    public ContractEmployee(int id, String name, String department, double salary, int contractDurationMonths) {
        super(id, name, department, salary);
        this.contractDurationMonths = contractDurationMonths;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.printf("Contract Duration: %d months%n", contractDurationMonths);
    }
    
    public int getContractDurationMonths() { return contractDurationMonths; }
}

public class Prac1_1 {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");
        
        try {
            Employee e1 = new PermanentEmployee(101, "Urval", "IT", 50000);
            Employee e2 = new ContractEmployee(102, "Pushti", "HR", 30000, 18);
            Employee e3 = new Employee();
            Employee e4 = new PermanentEmployee(103, "John", "Finance", 45000, 8000);

            System.out.println("Employee Details:");
            System.out.println("-".repeat(60));
            e1.display();
            System.out.println();
            e2.display();
            System.out.println();
            e3.display();
            System.out.println();
            e4.display();

            System.out.println("\n" + "=".repeat(60));
            System.out.println("Total Employees: " + Employee.getEmployeeCount());

            // Type checking with enhanced output
            System.out.println("\nEmployee Type Analysis:");
            checkEmployeeType(e1);
            checkEmployeeType(e2);
            checkEmployeeType(e3);
            checkEmployeeType(e4);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating employee: " + e.getMessage());
        }

        System.out.println("\n24CE055 <--> Urval Kheni");
    }
    
    private static void checkEmployeeType(Employee emp) {
        String type = "Regular Employee";
        if (emp instanceof PermanentEmployee) {
            type = "Permanent Employee";
        } else if (emp instanceof ContractEmployee) {
            type = "Contract Employee";
        }
        System.out.printf("Employee %s (%s) is a %s%n", 
                         emp.getName(), emp.getId(), type);
    }
}
