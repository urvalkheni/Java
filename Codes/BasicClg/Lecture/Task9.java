// make 10 threads with the help of array and in the sleep 1 to 2 sec with random function
import java.util.Random;

public class Task9 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) {
            final int threadNumber = i + 1;
            threads[i] = new Thread(() -> {
                try {
                    // Random sleep between 1000-2000 milliseconds (1-2 seconds)
                    int sleepTime = 1000 + random.nextInt(1000);
                    System.out.println("Thread " + threadNumber + " sleeping for " + sleepTime + "ms");
                    Thread.sleep(sleepTime);
                    System.out.println("Thread " + threadNumber + " completed");
                } catch (InterruptedException e) {
                    System.out.println("Thread " + threadNumber + " interrupted");
                }
            });
            threads[i].setName("Thread-" + threadNumber);
        }
        
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting");
            }
        }
        
        System.out.println("All threads completed!");
    }
}
