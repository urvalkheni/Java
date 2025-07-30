package Codes.BasicClg.Lecture;

class ThreadCreation implements Runnable {
    ThreadCreation() {}
    public void run(){
        try {
            System.out.println(""+Thread.currentThread().getName());
            Thread.sleep(1000);
            System.err.println(Thread.currentThread().getState());
        } 
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("In run method; thread name is :: "+ Thread.currentThread().getName());
    }
  
}

public class Task8 {
    public static void main(String[] args) {
        ThreadCreation myThread = new ThreadCreation();
        Thread myThread1= new Thread(myThread);
        // myThread.setName("Urval");
        System.err.println(myThread);
        myThread1.start();
        System.out.println(Thread.currentThread().getName() + " Currently in " + myThread1.getState());
    }
}
