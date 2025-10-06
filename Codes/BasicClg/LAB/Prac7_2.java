import java.util.*;

public class Prac7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        // Split into words
        String[] words = paragraph.toLowerCase().split("\\W+");

        // HashMap for word frequency
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("\nHashMap (Unordered): " + hashMap);

        // LinkedHashMap to maintain insertion order
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String word : words) {
            linkedHashMap.put(word, linkedHashMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("\nLinkedHashMap (Insertion order): " + linkedHashMap);

        // TreeMap to sort by key
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("\nTreeMap (Sorted by key): " + treeMap);

        System.out.println("24CE055<-->Urval Kheni");
    }
}
