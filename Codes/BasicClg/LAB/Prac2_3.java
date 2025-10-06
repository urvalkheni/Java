// Prac2_3.java
// Aim: Efficiently find all occurrences of a pattern in a long text using KMP Algorithm.

import java.util.*;

public class Prac2_3 {

    static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = 0;
            }
        }
        return lps;
    }

    static List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int n = text.length(), m = pattern.length();
        int[] lps = computeLPSArray(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                positions.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return positions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter long input text:");
        String text = sc.nextLine();
        System.out.println("Enter pattern to search:");
        String pattern = sc.nextLine();

        List<Integer> positions = KMPSearch(text, pattern);

        if (positions.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println("\nPattern found at positions (0-indexed):");
            for (int pos : positions)
                System.out.print(pos + " ");
            System.out.println();
        }

        sc.close();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
