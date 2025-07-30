package Codes.BasicClg.LAB.Practicallist;

import java.util.Arrays;


public class Simple {
    // Custom left trim
    public static String ltrim(String str) {
        return str.replaceAll("^\\s+", "");
    }

    // Custom right trim
    public static String rtrim(String str) {
        return str.replaceAll("\\s+$", "");
    }

    public static void main(String[] args) {
        String s1 = "Rahul Gandhi Urval Kheni";
        String s2 = "rahul gandhi urval kheni";
        String s5 = "Urval".intern(); 

        System.out.println("length of s1: " + s1.length());
        System.out.println("length of s2: " + s2.length());
        System.out.println("length of s5: " + s5.length());
        System.out.println(s5.charAt(2));                      // Prints 'v'
        System.out.println(s1.indexOf('K'));                   // Finds index of 'K'
        System.out.println(s1.substring(0, 10));               // First 10 characters
        System.out.println(s1.contains("Rahul Urval"));        // false
        System.out.println(s1.toUpperCase());                  // All uppercase
        System.out.println(s1.toLowerCase());                  // All lowercase
        System.out.println(s1.equalsIgnoreCase(s2));           // true
        System.out.println(s1.replace("Urval", "Kheni"));      // Replaces Urval
        System.out.println(s1.startsWith("Rahul"));            // true
        System.out.println(s1.endsWith("Kheni"));              // true
        System.out.println(s1.compareTo(s2));                  // case-sensitive compare
        System.out.println(s1.compareToIgnoreCase(s2));        // case-insensitive compare
        System.out.println(s1.trim());                         // trim both ends
        System.out.println(ltrim(s1));                         // left trim
        System.out.println(rtrim(s1));                         // right trim
        System.out.println(Arrays.toString(s1.split(" ")));    // splits by space
        //String Builder example
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb.toString());                     // Hello World
        sb.insert(5, ",");
        System.out.println(sb.toString());                     // Hello, World
        sb.delete(5, 6);
        System.out.println(sb.toString());                     // Hello World
        sb.reverse();
        System.out.println(sb.toString());                     // dlroW olleH
        sb.setLength(0);                                      // Clear the StringBuilder
        System.out.println("StringBuilder after clearing: " + sb.toString()); // Empty
        // StringBuffer example
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println(sbf.toString());                    // Hello World
        sbf.insert(5, ",");
        System.out.println(sbf.toString());                    // Hello, World
        sbf.delete(5, 6);
        System.out.println(sbf.toString());                    // Hello World
        sbf.reverse();
        System.out.println(sbf.toString());                    // dlroW olleH
        sbf.setLength(0);                                     // Clear the StringBuffer
        System.out.println("StringBuffer after clearing: " + sbf.toString()); // Empty
        

    }
}
