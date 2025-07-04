package Codes.BasicClg.Lecture;

public class Task3 {
    
    public static void main(String[] args) {
        double principal = 10000;     // P
        double rate = 0.05;           // r (5%)
        int time = 5;                 // t (years)
        int n = 4;                    // n (quarterly compounding)

        double amount = principal * Math.pow(1 + (rate / n), n * time);
        
        System.out.printf("Compound Interest Amount after %d years = ₹%.2f\n", time, amount);
    }
}
