// Prac2_1.java
// Aim: Sanitize chat messages by removing extra spaces, replacing bad words, and applying capitalization rules.

import java.util.*;
import java.util.regex.Pattern;

public class Prac2_1 {

    private static final List<String> DEFAULT_BAD_WORDS = Arrays.asList(
        "stupid", "idiot", "dumb", "hate", "fool", "loser"
    );

    static String removeExtraSpaces(String input) {
        if (input == null) return "";
        input = input.trim();
        return input.replaceAll("\\s+", " ");
    }

    static String censorWords(String text, List<String> badWords) {
        if (text == null || badWords == null) return text;
        
        for (String word : badWords) {
            // Use word boundaries and case-insensitive matching
            String pattern = "\\b" + Pattern.quote(word) + "\\b";
            text = text.replaceAll("(?i)" + pattern, "*".repeat(word.length()));
        }
        return text;
    }

    static String formatCapitalization(String text) {
        if (text == null || text.length() == 0) return text;
        
        StringBuilder sb = new StringBuilder(text.toLowerCase());
        
        // Capitalize first character
        if (sb.length() > 0) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        // Capitalize after sentence endings
        for (int i = 0; i < sb.length() - 2; i++) {
            char current = sb.charAt(i);
            if (current == '.' || current == '!' || current == '?') {
                // Find next letter after punctuation and space
                for (int j = i + 1; j < sb.length(); j++) {
                    if (Character.isLetter(sb.charAt(j))) {
                        sb.setCharAt(j, Character.toUpperCase(sb.charAt(j)));
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
    
    static String addProfanityFilter(String text) {
        // Enhanced profanity detection with leetspeak
        Map<String, String> leetMap = new HashMap<>();
        leetMap.put("@", "a");
        leetMap.put("3", "e");
        leetMap.put("1", "i");
        leetMap.put("0", "o");
        leetMap.put("5", "s");
        
        String normalized = text.toLowerCase();
        for (Map.Entry<String, String> entry : leetMap.entrySet()) {
            normalized = normalized.replace(entry.getKey(), entry.getValue());
        }
        
        return censorWords(text, DEFAULT_BAD_WORDS);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("=== Chat Message Sanitizer ===");
            System.out.print("Enter chat message: ");
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                System.out.println("Empty message provided!");
                return;
            }

            System.out.println("\nProcessing steps:");
            System.out.println("1. Original: \"" + input + "\"");

            // Step by step sanitization
            input = removeExtraSpaces(input);
            System.out.println("2. Spaces cleaned: \"" + input + "\"");

            input = addProfanityFilter(input);
            System.out.println("3. Profanity filtered: \"" + input + "\"");

            input = formatCapitalization(input);
            System.out.println("4. Capitalization fixed: \"" + input + "\"");

            System.out.println("\n" + "=".repeat(50));
            System.out.println("✅ SANITIZED MESSAGE:");
            System.out.println("\"" + input + "\"");
            
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        } finally {
            sc.close();
        }

        System.out.println("\n24CE055 <--> Urval Kheni");
    }
}
