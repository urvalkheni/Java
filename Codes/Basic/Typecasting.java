package Codes.Basic;

public class Typecasting {
    public static void main(String[] args) {
        // Implicit type casting (widening conversion)
        int intValue = 100;
        long longValue = intValue; // int to long
        float floatValue = longValue; // long to float
        double doubleValue = floatValue; // float to double

        System.out.println("Implicit Type Casting:");
        System.out.println("int to long: " + longValue);
        System.out.println("long to float: " + floatValue);
        System.out.println("float to double: " + doubleValue);

        // Explicit type casting (narrowing conversion)
        double anotherDoubleValue = 9.78;
        float anotherFloatValue = (float) anotherDoubleValue; // double to float
        long anotherLongValue = (long) anotherFloatValue; // float to long
        int anotherIntValue = (int) anotherLongValue; // long to int

        System.out.println("\nExplicit Type Casting:");
        System.out.println("double to float: " + anotherFloatValue);
        System.out.println("float to long: " + anotherLongValue);
        System.out.println("long to int: " + anotherIntValue);
        int urval = 128;
        byte byteValue = (byte) urval; // int to byte (narrowing conversion)
        System.out.println("\nByte value: " + byteValue);
    }
}
