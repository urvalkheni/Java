// Prac6_2.java
// Library book issue/return logging system

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LibraryLogger {
    private static final String LOG_FILE = "library_log.txt";

    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write("[" + timestamp + "] " + message);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error writing to log: " + e.getMessage());
        }
    }
}

public class Prac6_2 {
    public static void main(String[] args) {
        LibraryLogger.log("Urval issued 'Java Programming'.");
        LibraryLogger.log("Pushti returned 'Data Structures'.");
        LibraryLogger.log("Heet issued 'Computer Networks'.");
        System.out.println("Library log entries recorded successfully!");

        System.out.println("24CE055<-->Urval Kheni");
    }
}
