package Codes.BasicClg.LAB.Practicallist;
//This code is Employee Management System using Class and Object

import java.util.Scanner;
public class Prac_1_1 {

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = new Employee();
        // Using Scanner to take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details for Employee 1:");
        System.out.print("ID: ");
        emp1.setId(sc.nextInt());
        sc.nextLine(); // Consume newline
        System.out.print("Name: ");
        emp1.setName(sc.nextLine());
        System.out.print("Department: ");
        emp1.setDepartment(sc.nextLine());
        System.out.print("Salary: ");
        emp1.setSalary(sc.nextFloat());
        sc.nextLine(); // Consume newline
        System.out.println("Enter details for Employee 2:");
        System.out.print("ID: ");
        emp2.setId(sc.nextInt());
        sc.nextLine(); // Consume newline
        System.out.print("Name: ");
        emp2.setName(sc.nextLine());
        System.out.print("Department: ");
        emp2.setDepartment(sc.nextLine());
        System.out.print("Salary: ");
        emp2.setSalary(sc.nextFloat());
        sc.nextLine(); // Consume newline
        System.out.println("Enter details for Employee 3:");
        System.out.print("ID: ");
        emp3.setId(sc.nextInt());
        sc.nextLine(); // Consume newline
        System.out.print("Name: ");
        emp3.setName(sc.nextLine());
        System.out.print("Department: ");
        emp3.setDepartment(sc.nextLine());
        System.out.print("Salary: ");
        emp3.setSalary(sc.nextFloat());
        sc.nextLine(); // Consume newline
        System.out.println("Displaying Employee Details:");
        System.out.println("Employee 1:");
        System.out.println("ID: " + emp1.getId());
        System.out.println("Name: " + emp1.getName());
        System.out.println("Department: " + emp1.getDepartment());
        System.out.println("Salary: " + emp1.getSalary());
        System.out.println("Employee 2:");
        System.out.println("ID: " + emp2.getId());
        System.out.println("Name: " + emp2.getName());
        System.out.println("Department: " + emp2.getDepartment());
        System.out.println("Salary: " + emp2.getSalary());
        System.out.println("Employee 3:");
        System.out.println("ID: " + emp3.getId());
        System.out.println("Name: " + emp3.getName());
        System.out.println("Department: " + emp3.getDepartment());
        System.out.println("Salary: " + emp3.getSalary());
        sc.close();
    }
}
