import java.util.*;

class Sanitizer {
    private static final Set<String> INAPPROPRIATE_WORDS = new HashSet<>(Arrays.asList(
            "damn", "hell", "shit", "crap", "wtf", "lol"
    ));

    public static String removeExtraSpaces(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String replaceInappropriateWords(String input) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            String wordClean = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (INAPPROPRIATE_WORDS.contains(wordClean)) {
                words[i] = words[i].replaceAll("(?i)\\b" + wordClean + "\\b", "***");
            }
        }
        return String.join(" ", words);
    }

    public static String formatCapitalization(String input) {
        if (input.isEmpty()) return input;
        String[] sentences = input.split("(?<=[.!?])\\s*");
        StringBuilder formatted = new StringBuilder();
        for (String sentence : sentences) {
            sentence = sentence.trim().toLowerCase();
            if (!sentence.isEmpty()) {
                formatted.append(Character.toUpperCase(sentence.charAt(0)))
                        .append(sentence.substring(1))
                        .append(" ");
            }
        }
        return formatted.toString().trim();
    }

    public static String sanitize(String input) {
        String step1 = removeExtraSpaces(input);
        String step2 = replaceInappropriateWords(step1);
        String step3 = formatCapitalization(step2);
        return step3;
    }
}

public class Prac2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your chat message:");
        String input = scanner.nextLine();
        String sanitized = Sanitizer.sanitize(input);
        System.out.println("Sanitized message: " + sanitized);
    }
}
