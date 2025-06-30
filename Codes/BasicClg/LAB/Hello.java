package Codes.BasicClg.LAB;

public class Hello {
    public static void main(String[] args) {
        Display display = new Display();
        display.show();
        Sum sum = new Sum();
        int result = sum.add(5, 10);
        System.out.println("Sum: " + result);
    }
}
// This class demonstrates the use of Display and Sum classes.
// It creates instances of both classes and calls their methods.