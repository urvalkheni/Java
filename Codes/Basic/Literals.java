package Codes.Basic;

public class Literals {
    public static void main(String[] args) {
        // Integer literals
        int decimal = 100; // Decimal
        int octal = 0144; // Octal (equivalent to 100 in decimal)
        int hexadecimal = 0x64; // Hexadecimal (equivalent to 100 in decimal)
        System.out.println("Decimal: " + decimal);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);

        // Floating-point literals
        float floatLiteral = 3.14f; // Float literal
        double doubleLiteral = 3.14159; // Double literal
        System.out.println("Float: " + floatLiteral);
        System.out.println("Double: " + doubleLiteral);

        // Character literal
        char charLiteral = 'A'; // Character literal
        System.out.println("Character: " + charLiteral);

        // String literal
        String stringLiteral = "Hello, World!"; // String literal
        System.out.println("String: " + stringLiteral);

        // Boolean literals
        boolean trueLiteral = true; // Boolean true literal
        boolean falseLiteral = false; // Boolean false literal
        System.out.println("Boolean True: " + trueLiteral);
        System.out.println("Boolean False: " + falseLiteral);
    }
}
