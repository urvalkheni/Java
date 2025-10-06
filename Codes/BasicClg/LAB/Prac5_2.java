// Prac5_2.java
// Demonstrates synchronized methods for deposit and withdrawal

class BankAccountSync {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " | Insufficient funds!");
        }
    }
}

class DepositTask implements Runnable {
    private final BankAccountSync account;

    public DepositTask(BankAccountSync account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(200);
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}

class WithdrawTask implements Runnable {
    private final BankAccountSync account;

    public WithdrawTask(BankAccountSync account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(150);
            try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}

public class Prac5_2 {
    public static void main(String[] args) {
    BankAccountSync acc = new BankAccountSync();

    Thread t1 = new Thread(new DepositTask(acc), "Depositor-1");
    Thread t2 = new Thread(new WithdrawTask(acc), "Withdrawer-1");
    Thread t3 = new Thread(new WithdrawTask(acc), "Withdrawer-2");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
