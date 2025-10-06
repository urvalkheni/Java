// Prac5_3.java
// Each thread reads one file and counts lines concurrently

import java.io.*;

class FileReaderThread extends Thread {
    private String fileName;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.readLine() != null)
                lineCount++;
            System.out.println(Thread.currentThread().getName() + " -> " + fileName + ": " + lineCount + " lines");
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName() + " -> Error reading " + fileName + ": " + e.getMessage());
        }
    }
}

public class Prac5_3 {
    public static void main(String[] args) {
        // Make sure these files exist in your project directory
        FileReaderThread t1 = new FileReaderThread("file1.txt");
        FileReaderThread t2 = new FileReaderThread("file2.txt");
        FileReaderThread t3 = new FileReaderThread("file3.txt");

        t1.setName("Reader-1");
        t2.setName("Reader-2");
        t3.setName("Reader-3");

        System.out.println("Starting file readers...\n");
        t1.start();
        t2.start();
        t3.start();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
