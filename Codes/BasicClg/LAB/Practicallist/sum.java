package Codes.BasicClg.LAB.Practicallist;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
       int number1;
       int number2;
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter first number: ");
        number1 = sc.nextInt();       
        System.out.print("Enter second number: ");
        number2 = sc.nextInt();
        int sum = number1 + number2;
        System.out.println("The sum of " + number1 + " and " + number2 + " is: " + sum);
        sc.close();
    }
}
