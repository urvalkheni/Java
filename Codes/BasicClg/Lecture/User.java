
import java.util.Scanner;

class myExeption extends Exception {
    public myExeption(String message) {
        super(message);
    }
}

public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        try {
            if (age < 18) {
                throw new myExeption("You are not eligible");
            } else if (age > 60) {
                throw new myExeption("You don't need a license");
            } else {
                System.out.println("You are eligible for a license.");
            }
        } catch (myExeption e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}