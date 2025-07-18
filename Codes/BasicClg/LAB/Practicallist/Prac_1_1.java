package Codes.BasicClg.LAB.Practicallist;

import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;
    private float salary;

    static int employeeCount = 0;

    public Employee() {
        this(0, "Unknown", "Not Assigned", 0.0f);
        System.out.println("Default Constructor Called.");
    }

    public Employee(int id, String name, String department, float salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        employeeCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.printf("Salary     : ₹%.2f%n", salary);
    }
}

class PermanentEmployee extends Employee {
    public PermanentEmployee() {
        super();
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee() {
        super();
    }
}

public class Prac_1_1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Employee[] employees = new Employee[3];

            for (int i = 0; i < employees.length; i++) {
                System.out.println("\nEnter details for Employee " + (i + 1) + ":");

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String department = sc.nextLine();

                System.out.print("Salary: ");
                float salary = sc.nextFloat();
                sc.nextLine();

                Employee e = (i % 2 == 0) ? new PermanentEmployee() : new ContractEmployee();
                e.setId(id);
                e.setName(name);
                e.setDepartment(department);
                e.setSalary(salary);

                employees[i] = e;
            }

            System.out.println("\n========= Employee List =========");
            for (int i = 0; i < employees.length; i++) {
                System.out.println("Employee " + (i + 1) + ":");
                employees[i].displayInfo();

                if (employees[i] instanceof PermanentEmployee) {
                    System.out.println("Type       : Permanent Employee");
                } else if (employees[i] instanceof ContractEmployee) {
                    System.out.println("Type       : Contract Employee");
                }

                System.out.println("---------------------------------");
            }

            System.out.println("Total Employees Created: " + Employee.employeeCount);
        }
    }
}
