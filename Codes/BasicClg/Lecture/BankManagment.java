import java.util.Scanner;

class BankAccount {
    private int balance = 2000;

    public synchronized void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to deposit invalid amount: " + amount);
        }
    }

    public synchronized void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw invalid amount: " + amount);
        } else if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " (Insufficient funds)");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class Customer implements Runnable {
    private BankAccount account;
    private Scanner scanner;

    public Customer(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Enter deposit amount:");
        int depositAmount = getValidAmount();
        account.deposit(depositAmount);

        System.out.println(Thread.currentThread().getName() + ": Enter withdrawal amount:");
        int withdrawAmount = getValidAmount();
        account.withdraw(withdrawAmount);

        System.out.println(Thread.currentThread().getName() + ": Transaction complete. Final Balance: " + account.getBalance());
    }

    private int getValidAmount() {
        int amount;
        while (true) {
            try {
                amount = Integer.parseInt(scanner.nextLine());
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Amount must be positive. Try again:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number:");
            }
        }
        return amount;
    }
}

public class BankManagment {
    public static void main(String[] args) {
        System.out.println("Bank Management System");
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Customer(account), "Customer1");
        Thread t2 = new Thread(new Customer(account), "Customer2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All transactions complete. Final Balance: " + account.getBalance());
    }
}