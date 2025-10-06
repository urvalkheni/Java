// Prac4_1.java
import java.util.*;

public class Prac4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter operator (+, -, *, /): ");
            char op = sc.nextLine().charAt(0);

            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(sc.nextLine());

            double result = 0;

            switch (op) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0)
                        throw new ArithmeticException("Division by zero is not allowed.");
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operator!");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numeric values.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Calculation finished.");
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
