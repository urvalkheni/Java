package Codes.BasicClg.Lecture;
abstract class Game{
    abstract void play();    
    public void start() {
        System.out.println("Game is starting...");
    }
    
    public void end() {
        System.out.println("Game has ended.");
    }
}
class Cricket extends Game{
    void play() {
        System.out.println("Playing Cricket");
    }
}
class Tennis extends Game{
    void play() {
        System.out.println("Playing Tennis");
    }
}

public class Task4 {
    public static void main(String[] args) {
        Game cricket = new Cricket();
        Game tennis = new Tennis();
        
        cricket.start();
        cricket.play();
        cricket.end();
        System.out.println();
        tennis.start();
        tennis.play();
        tennis.end();
    }
}
