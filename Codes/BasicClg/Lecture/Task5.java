package Codes.BasicClg.Lecture;

import java.util.Scanner;

interface Add {
    int addi(int a, int b);
}

interface Multi {
    int mul(int a, int b);
}

interface Sub {
    int subt(int a, int b);
}

interface Division {
    double divi(int a, int b);
}

interface Logarithmic {
    double logBase10(double x);
    double naturalLog(double x);
}

class Calculator implements Add, Multi, Sub, Division, Logarithmic {
    public int addi(int a, int b) {
        return a + b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int subt(int a, int b) {
        return a - b;
    }

    public double divi(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
        return (double) a / b;
    }

    public double logBase10(double x) {
        if (x <= 0) {
            System.out.println("Error: Logarithm base 10 undefined for zero or negative numbers!");
            return Double.NaN;
        }
        return Math.log10(x);
    }

    public double naturalLog(double x) {
        if (x <= 0) {
            System.out.println("Error: Natural logarithm undefined for zero or negative numbers!");
            return Double.NaN;
        }
        return Math.log(x);
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("Enter first number (a): ");
        int a = sc.nextInt();

        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();

        System.out.println("\nChoose operation:");
        System.out.println("1. Addition (a + b)");
        System.out.println("2. Subtraction (a - b)");
        System.out.println("3. Multiplication (a * b)");
        System.out.println("4. Division (a / b)");
        System.out.println("5. Log base 10 of a");
        System.out.println("6. Natural log (ln) of a");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Addition: " + calculator.addi(a, b));
                break;
            case 2:
                System.out.println("Subtraction: " + calculator.subt(a, b));
                break;
            case 3:
                System.out.println("Multiplication: " + calculator.mul(a, b));
                break;
            case 4:
                System.out.println("Division: " + calculator.divi(a, b));
                break;
            case 5:
                System.out.println("Log base 10 of a: " + calculator.logBase10(a));
                break;
            case 6:
                System.out.println("Natural log (ln) of a: " + calculator.naturalLog(a));
                break;
            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
