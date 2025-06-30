package Codes.BasicClg.LAB;

public class TypePromotion {
    public static void main(String[] args) {
        // Basic Integer Addition
        System.out.println("int + int + int: " + (1 + 2 + 3)); // 6

        // char is promoted to int (ASCII value of '2' = 50)
        System.out.println("int + char + int: " + (1 + '2' + 3)); // 1 + 50 + 3 = 54

        // String concatenation starts from left to right
        System.out.println("int + String + int: " + (1 + "2" + 3)); // "1" + "2" = "12", then + 3 = "123"
        System.out.println("int + int + String: " + (1 + 2 + "3")); // 1 + 2 = 3, then + "3" = "33"

        // float + int -> float
        float f = 5.5f;
        int i = 2;
        System.out.println("float + int: " + (f + i)); // 5.5 + 2 = 7.5

        // double + int -> double
        double d = 6.7;
        System.out.println("double + int: " + (d + i)); // 6.7 + 2 = 8.7

        // long + int -> long
        long l = 100L;
        System.out.println("long + int: " + (l + i)); // 100 + 2 = 102

        // byte + byte -> int
        byte b1 = 10;
        byte b2 = 20;
        int sum = b1 + b2; // internally promoted to int
        System.out.println("byte + byte (promoted to int): " + sum);

        // short + short -> int
        short s1 = 1000;
        short s2 = 2000;
        int total = s1 + s2;
        System.out.println("short + short (promoted to int): " + total);

        // char + char -> int
        char c1 = 'A'; // 65
        char c2 = 'B'; // 66
        System.out.println("char + char (promoted to int): " + (c1 + c2)); // 131

        // Mixing char, int, and float
        System.out.println("char + int + float: " + (c1 + i + f)); // 65 + 2 + 5.5 = 72.5

        // Mixing everything into a String
        System.out.println("String + int + char + double: " + ("Ans: " + i + c1 + d)); // "Ans: " + "2A6.7"
    }
}
