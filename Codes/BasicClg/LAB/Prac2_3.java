// Prac2_3.java
// Aim: Efficiently find all occurrences of a pattern in a long text using KMP Algorithm.

import java.util.*;

public class Prac2_3 {

    /**
     * Compute the Longest Proper Prefix which is also Suffix (LPS) array
     * for the KMP algorithm preprocessing step.
     */
    static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        // The loop calculates lps[i] for i = 1 to m-1
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    // Also, note that we do not increment i here
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP Algorithm implementation for pattern searching
     */
    static List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        
        if (m == 0 || n == 0 || m > n) {
            return positions;
        }

        // Preprocess the pattern (calculate lps[] array)
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                positions.add(i - j); // Found pattern at index i-j
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return positions;
    }
    
    /**
     * Case-insensitive KMP search
     */
    static List<Integer> KMPSearchIgnoreCase(String text, String pattern) {
        return KMPSearch(text.toLowerCase(), pattern.toLowerCase());
    }
    
    /**
     * Display search results with context
     */
    static void displayResults(String text, String pattern, List<Integer> positions) {
        if (positions.isEmpty()) {
            System.out.println("❌ Pattern not found in the text.");
            return;
        }
        
        System.out.printf("✅ Pattern '%s' found %d time(s):%n", pattern, positions.size());
        System.out.println("-".repeat(50));
        
        for (int i = 0; i < positions.size(); i++) {
            int pos = positions.get(i);
            
            // Show context around the match
            int start = Math.max(0, pos - 10);
            int end = Math.min(text.length(), pos + pattern.length() + 10);
            
            // Highlight the pattern in the context
            String beforePattern = text.substring(start, pos);
            String matchedPattern = text.substring(pos, pos + pattern.length());
            String afterPattern = text.substring(pos + pattern.length(), end);
            
            System.out.printf("%d. Position %d: ...%s[%s]%s...%n", 
                             i + 1, pos, beforePattern, matchedPattern.toUpperCase(), afterPattern);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("=== KMP Pattern Search Algorithm ===");
            System.out.println("Enter long input text (or press Enter for sample text):");
            String text = sc.nextLine();
            
            // Use sample text if empty input
            if (text.trim().isEmpty()) {
                text = "This is a sample text for demonstrating the KMP algorithm. " +
                       "The algorithm efficiently finds patterns in text. " +
                       "Algorithm implementation is crucial for text processing.";
                System.out.println("Using sample text: \"" + text + "\"");
            }
            
            System.out.println("Enter pattern to search:");
            String pattern = sc.nextLine();
            
            if (pattern.trim().isEmpty()) {
                System.out.println("Empty pattern provided!");
                return;
            }

            System.out.println("\n" + "=".repeat(60));
            System.out.printf("Searching for: '%s'%n", pattern);
            System.out.printf("In text of length: %d characters%n", text.length());
            System.out.println("=".repeat(60));

            // Perform case-sensitive search
            long startTime = System.nanoTime();
            List<Integer> positions = KMPSearch(text, pattern);
            long endTime = System.nanoTime();
            
            System.out.println("\n🔍 Case-sensitive search:");
            displayResults(text, pattern, positions);
            
            // Perform case-insensitive search
            List<Integer> positionsIgnoreCase = KMPSearchIgnoreCase(text, pattern);
            
            System.out.println("\n🔍 Case-insensitive search:");
            displayResults(text, pattern, positionsIgnoreCase);
            
            // Performance info
            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%n⏱️  Search completed in %.3f ms%n", timeMs);
            
        } catch (Exception e) {
            System.err.println("Error during search: " + e.getMessage());
        }

        System.out.println("\n24CE055 <--> Urval Kheni");
    }
}
