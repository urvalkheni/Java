package Codes.BasicClg.Lecture;
interface Add{
    int addi(int a, int b);
}
interface Multi{
    int mul(int a,int b);
}
interface Sub{
    int subt(int a, int b);
}
interface Division{
    double divi(int a, int b);
}
class Calculator implements Add, Multi, Sub, Division {
     public int addi(int a, int b) {
        return a + b;
    }
    public int mul(int a,int b) {
        return a * b;
    }
    public int subt(int a, int b) {
        return a - b;
    }
    public double divi(int a, int b) {
        return (double) a / b;
    }
}


public class Task5 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 5;
        System.out.println("Addition: " + calculator.addi(a, b));
        System.out.println("Multiplication: " + calculator.mul(a, b));
        System.out.println("Subtraction: " + calculator.subt(a, b));
        System.out.println("Division: " + calculator.divi(a, b));

    }
    
}
