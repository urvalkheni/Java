interface Switchable {
    void turnOn();
    void turnOff();

    default void status() {
        System.out.println("Device status checked via Switchable interface.");
    }

    static void energySavingTip() {
        System.out.println("Tip: Turn off unused devices to save energy!");
    }
}

interface Schedulable {
    void schedule(String time);
}

interface SensorEnabled {
    void detectMotion();
}

class Light implements Switchable, Schedulable {
    public void turnOn() {
        System.out.println("Light turned ON.");
    }

    public void turnOff() {
        System.out.println("Light turned OFF.");
    }

    public void schedule(String time) {
        System.out.println("Light scheduled to turn on at " + time);
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan started.");
    }

    public void turnOff() {
        System.out.println("Fan stopped.");
    }
}

class Camera implements Switchable, SensorEnabled {
    public void turnOn() {
        System.out.println("Camera activated.");
    }

    public void turnOff() {
        System.out.println("Camera deactivated.");
    }

    public void detectMotion() {
        System.out.println("Motion detected! Recording started.");
    }
}

public class Prac3_2 {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        Camera cam = new Camera();

        light.turnOn();
        light.schedule("6:30 PM");

        fan.turnOn();
        fan.status();

        cam.turnOn();
        cam.detectMotion();

        Switchable.energySavingTip();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
