// Prac4_2.java
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) throws InvalidTransactionException {
        if (amount <= 0)
            throw new InvalidTransactionException("Deposit amount must be greater than zero.");
        balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + balance);
    }

    public void withdraw(double amount) throws InvalidTransactionException {
        if (amount <= 0)
            throw new InvalidTransactionException("Withdrawal amount must be greater than zero.");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient funds! Current balance: " + balance);
        balance -= amount;
        System.out.println("Withdrew: " + amount + " | Balance: " + balance);
    }
}

public class Prac4_2 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);

        try {
            acc.deposit(500);
            acc.withdraw(200);
            acc.withdraw(2000); // Should throw InsufficientFundsException
            acc.deposit(-100);  // Should throw InvalidTransactionException
        } catch (InvalidTransactionException e) {
            System.out.println("Transaction Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Bank Error: " + e.getMessage());
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
