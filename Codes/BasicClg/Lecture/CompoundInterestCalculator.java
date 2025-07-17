package Codes.BasicClg.Lecture;
java.util.Scanner;
public class CompoundInterestCalculator {
    private double principal;
    private double rate;
    private int time;
    private int compoundsPerYear;

    public CompoundInterestCalculator(double principal, double rate, int time, int compoundsPerYear) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
        this.compoundsPerYear = compoundsPerYear;
    }

    public double calculateAmount() {
        return principal * Math.pow(1 + (rate / compoundsPerYear), compoundsPerYear * time);
    }

    public double calculateInterest() {
        return calculateAmount() - principal;
    }

    public void displayResult() {
        System.out.println("\n=== Compound Interest Result ===");
        System.out.printf("Principal Amount      : ₹%.2f%n", principal);
        System.out.printf("Annual Interest Rate  : %.2f%%%n", rate * 100);
        System.out.printf("Time Period           : %d years%n", time);
        System.out.printf("Compounded            : %d times per year%n", compoundsPerYear);
        System.out.printf("Total Amount          : ₹%.2f%n", calculateAmount());
        System.out.printf("Compound Interest     : ₹%.2f%n", calculateInterest());
    }
}
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Compound Interest Calculator ===");

        System.out.print("Enter Principal Amount (₹): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Annual Interest Rate (%): ");
        double rate = scanner.nextDouble() / 100;  // convert to decimal

        System.out.print("Enter Time (in years): ");
        int time = scanner.nextInt();

        System.out.print("Enter Compounding Frequency per year (e.g., 1 for yearly, 4 for quarterly): ");
        int n = scanner.nextInt();

        CompoundInterestCalculator calculator = new CompoundInterestCalculator(principal, rate, time, n);
        calculator.displayResult();

        scanner.close();
    }
}
