// package ThreadDemo.Practical1;

public class ThreadPractical1 {

    // 1) Thread subclass that prints numbers 1 to 5
    static class NumberPrinter extends Thread {
        public NumberPrinter(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(getName() + " prints: " + i);
                    Thread.sleep(1000);  // 1 second delay
                }
            } catch (InterruptedException e) {
                System.err.println(getName() + " interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }

    // 2) Runnable implementation that prints letters A to E
    static class LetterPrinter implements Runnable {
        private final String name;

        public LetterPrinter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                for (char c = 'A'; c <= 'E'; c++) {
                    System.out.println(name + " prints: " + c);
                    Thread.sleep(1000);  // 1 second delay
                }
            } catch (InterruptedException e) {
                System.err.println(name + " interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        // Create and start the NumberPrinter thread
        NumberPrinter numThread = new NumberPrinter("NumberThread");
        numThread.start();

        // Create and start the LetterPrinter thread
        Thread letterThread = new Thread(new LetterPrinter("LetterThread"));
        letterThread.start();

        // Wait for both to complete
        try {
            numThread.join();
            // Join LetterPrinter thread 
            letterThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting");
            Thread.currentThread().interrupt();
        }

        System.out.println("Both threads have finished.");
    }
}