// Prac6_3.java
// Expense tracker with daily entries and monthly summary

import java.io.*;
import java.time.LocalDate;

class ExpenseTracker {
    private static final String FILE_NAME = "expenses.txt";

    public static void addExpense(String date, String category, double amount) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(date + "," + category + "," + amount);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing expense: " + e.getMessage());
        }
    }

    public static void generateSummary() {
        double total = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                total += Double.parseDouble(parts[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("Monthly Summary: Total Expenses = ₹" + total);
    }
}

public class Prac6_3 {
    public static void main(String[] args) {
        // Add daily entries
        ExpenseTracker.addExpense(LocalDate.now().toString(), "Food", 250);
        ExpenseTracker.addExpense(LocalDate.now().toString(), "Transport", 100);
        ExpenseTracker.addExpense(LocalDate.now().toString(), "Books", 300);

        System.out.println("Daily expenses recorded.");
        ExpenseTracker.generateSummary();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
