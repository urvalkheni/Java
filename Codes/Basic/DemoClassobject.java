package Codes.Basic;
class Calc {
    int add(int a, int b) {
        return a + b;
    }
}

public class DemoClassobject {  
    public static void main(String[] args) {
        Calc calc = new Calc();
        int result = calc.add(5, 10);
        System.out.println("The sum is: " + result);
    }
}
