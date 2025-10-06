// Prac4_4.java
import java.util.*;

public class Prac4_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter space-separated signals: ");
        String input = sc.nextLine();

        String[] signals = input.split(" ");
        int sum = 0;
        int corruptCount = 0;

        for (String signal : signals) {
            try {
                int val = Integer.parseInt(signal);
                if (val < 1 || val > 1000)
                    throw new IllegalArgumentException("Out of range: " + val);
                sum += val;
            } catch (NumberFormatException e) {
                System.out.println("Corrupt signal (not a number): " + signal);
                corruptCount++;
            } catch (IllegalArgumentException e) {
                System.out.println("Corrupt signal (out of range): " + signal);
                corruptCount++;
            }
        }

        System.out.println("Sum of valid signals: " + sum);
        System.out.println("Total corrupt signals: " + corruptCount);

        System.out.println("24CE055<-->Urval Kheni");
    }
}
