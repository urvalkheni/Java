// Prac2_1.java
// Aim: Sanitize chat messages by removing extra spaces, replacing bad words, and applying capitalization rules.

import java.util.*;

public class Prac2_1 {

    static String removeExtraSpaces(String input) {
        input = input.trim();
        return input.replaceAll("\\s+", " ");
    }

    static String censorWords(String text, List<String> badWords) {
        for (String word : badWords) {
            String pattern = "\\b" + word + "\\b";
            text = text.replaceAll("(?i)" + pattern, "***");
        }
        return text;
    }

    static String formatCapitalization(String text) {
        if (text.length() == 0) return text;
        StringBuilder sb = new StringBuilder(text.toLowerCase());
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        for (int i = 0; i < sb.length() - 2; i++) {
            if (sb.charAt(i) == '.' || sb.charAt(i) == '!' || sb.charAt(i) == '?') {
                if (i + 2 < sb.length())
                    sb.setCharAt(i + 2, Character.toUpperCase(sb.charAt(i + 2)));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter chat message: ");
        String input = sc.nextLine();

        List<String> badWords = Arrays.asList("stupid", "idiot", "dumb");

        input = removeExtraSpaces(input);
        input = censorWords(input, badWords);
        input = formatCapitalization(input);

        System.out.println("\nSanitized Message:\n" + input);
        sc.close();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
