// Prac2_2.java
// Aim: Identify palindrome words and sentences in a paragraph.

import java.util.*;

public class Prac2_2 {

    static boolean isPalindrome(String text) {
        String cleaned = text.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return !cleaned.isEmpty() && cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        System.out.println("\nPalindrome Words:");
        String[] words = paragraph.split("\\s+");
        for (String word : words) {
            String cleaned = word.replaceAll("[^A-Za-z0-9]", "");
            if (isPalindrome(cleaned))
                System.out.println("-> " + cleaned);
        }

        System.out.println("\nPalindrome Sentences:");
        String[] sentences = paragraph.split("[.!?]");
        for (String sentence : sentences) {
            if (isPalindrome(sentence))
                System.out.println("-> " + sentence.trim());
        }

        sc.close();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
