// Prac2_2.java
// Aim: Identify palindrome words and sentences in a paragraph.

import java.util.*;

public class Prac2_2 {

    static boolean isPalindrome(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (cleaned.isEmpty()) return false;
        
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    static boolean isPalindromeIgnoreCase(String text) {
        if (text == null) return false;
        String cleaned = text.replaceAll("\\s+", "").toLowerCase();
        if (cleaned.isEmpty()) return false;
        
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    static List<String> findPalindromeWords(String text) {
        List<String> palindromes = new ArrayList<>();
        String[] words = text.split("\\s+");
        
        for (String word : words) {
            String cleaned = word.replaceAll("[^A-Za-z0-9]", "");
            if (cleaned.length() >= 2 && isPalindrome(cleaned)) {
                palindromes.add(cleaned);
            }
        }
        return palindromes;
    }
    
    static List<String> findPalindromeSentences(String text) {
        List<String> palindromes = new ArrayList<>();
        String[] sentences = text.split("[.!?]");
        
        for (String sentence : sentences) {
            String trimmed = sentence.trim();
            if (trimmed.length() >= 2 && isPalindromeIgnoreCase(trimmed)) {
                palindromes.add(trimmed);
            }
        }
        return palindromes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("=== Palindrome Detector ===");
            System.out.println("Enter a paragraph (or try: 'A man a plan a canal Panama! Racecar runs fast. Was it a car or a cat I saw?'):");
            String paragraph = sc.nextLine();

            if (paragraph.trim().isEmpty()) {
                System.out.println("Empty input provided!");
                return;
            }

            System.out.println("\nAnalyzing text: \"" + paragraph + "\"");
            System.out.println("=".repeat(60));

            // Find palindrome words
            List<String> palindromeWords = findPalindromeWords(paragraph);
            System.out.println("\n🔤 Palindrome Words Found:");
            if (palindromeWords.isEmpty()) {
                System.out.println("   No palindrome words found.");
            } else {
                for (int i = 0; i < palindromeWords.size(); i++) {
                    System.out.printf("   %d. %s%n", i + 1, palindromeWords.get(i));
                }
            }

            // Find palindrome sentences
            List<String> palindromeSentences = findPalindromeSentences(paragraph);
            System.out.println("\n📝 Palindrome Sentences Found:");
            if (palindromeSentences.isEmpty()) {
                System.out.println("   No palindrome sentences found.");
            } else {
                for (int i = 0; i < palindromeSentences.size(); i++) {
                    System.out.printf("   %d. \"%s\"%n", i + 1, palindromeSentences.get(i));
                }
            }

            // Summary
            System.out.println("\n" + "=".repeat(60));
            System.out.printf("📊 Summary: %d palindrome word(s), %d palindrome sentence(s)%n", 
                             palindromeWords.size(), palindromeSentences.size());
                             
        } catch (Exception e) {
            System.err.println("Error processing text: " + e.getMessage());
        } finally {
            sc.close();
        }

        System.out.println("\n24CE055 <--> Urval Kheni");
    }
}
