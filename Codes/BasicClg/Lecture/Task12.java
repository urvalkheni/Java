abstract class Instrument {
    abstract void play();
    abstract String what();
    abstract void adjust();
}

class Wind extends Instrument {
    @Override
    public void play() {
        System.out.println("Wind instrument played");
    }
    @Override
    public String what() {
        return "Wind instrument";
    }
    @Override
    public void adjust() {
        System.out.println("Wind instrument tuned properly");
    }
}

class Woodwind extends Wind {
    @Override
    public void play() {
        System.out.println("Woodwind instrument played");
    }
    @Override
    public String what() {
        return "Woodwind instrument";
    }
}

class Brass extends Wind {
    @Override
    public void play() {
        System.out.println("Brass instrument played");
    }
    @Override
    public String what() {
        return "Brass instrument";
    }
}

class Percussion extends Instrument {
    @Override
    public void play() {
        System.out.println("Percussion instrument played");
    }
    @Override
    public String what() {
        return "Percussion instrument";
    }
    @Override
    public void adjust() {
        System.out.println("Percussion instrument tuned properly");
    }
}

class Stringed extends Instrument {
    @Override
    public void play() {
        System.out.println("Stringed instrument played");
    }
    @Override
    public String what() {
        return "Stringed instrument";
    }
    @Override
    public void adjust() {
        System.out.println("Stringed instrument tuned properly");
    }
}

public class Task12 {
    public static void main(String[] args) {
        Instrument w = new Woodwind();
        Instrument b = new Brass();
        Instrument p = new Percussion();
        Instrument s = new Stringed();

        w.play();
        System.out.println(w.what());
        w.adjust();
        System.out.println("\n");
        b.play();
        System.out.println(b.what());
        b.adjust();
        System.out.println("\n");
        p.play();
        System.out.println(p.what());
        p.adjust();
        System.out.println("\n");
        s.play();
        System.out.println(s.what());
        s.adjust();
        System.out.println("\n");
    }
}