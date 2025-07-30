package Codes.BasicClg.Lecture;
import Codes.BasicClg.Lecture.calc.Addition;
import Codes.BasicClg.Lecture.calc.Subtraction;
import Codes.BasicClg.Lecture.calc.Multiplication;
import Codes.BasicClg.Lecture.calc.Division;

public class Task10 {
    public static void main(String[] args) {
        int a = 10;
        int b = 2;
        
        Addition add = new Addition();
        Subtraction sub = new Subtraction();
        Multiplication mul = new Multiplication();
        Division div = new Division();
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition: " + add.Add(a, b));
        System.out.println("Subtraction: " + sub.subt(a, b));
        System.out.println("Multiplication: " + mul.Multi(a, b));
        System.out.println("Division: " + div.Div(a, b));
    }
}
