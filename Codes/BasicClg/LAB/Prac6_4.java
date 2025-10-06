// Prac6_4.java
// Counts word frequency and displays top 10 frequent words

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Prac6_4 {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty())
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            // Sort by frequency (descending)
            List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("---- Top 10 Most Frequent Words ----");
            for (int i = 0; i < Math.min(10, sortedList.size()); i++) {
                Entry<String, Integer> e = sortedList.get(i);
                System.out.println(e.getKey() + " : " + e.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
