
interface Switchable {

    void turnOn();

    void turnOff();

    boolean isOn();

    default void displayPowerStatus() {
        System.out.println("Power: " + (isOn() ? "ON" : "OFF"));
    }

    static void safetyNotice() {
        System.out.println("Use devices responsibly and follow safety guidelines.");
    }
}

interface Schedulable {

    void schedule();

    void cancelSchedule();

    default void displayScheduleInfo() {
        System.out.println("Schedule info: default schedule");
    }

    static boolean isValidHour(int hour24) {
        return hour24 >= 0 && hour24 < 24;
    }
}

interface SensorEnabled {

    void enableSensor();

    void disableSensor();

    boolean isSensorEnabled();

    default void displaySensorStatus() {
        System.out.println("Sensor: " + (isSensorEnabled() ? "ENABLED" : "DISABLED"));
    }
}

// Concrete device classes applying Interface Segregation Principle
class CameraDevice implements Switchable, SensorEnabled {

    private boolean power;
    private boolean sensor;

    public void turnOn() {
        power = true;
    }

    public void turnOff() {
        power = false;
    }

    public boolean isOn() {
        return power;
    }

    public void enableSensor() {
        sensor = true;
    }

    public void disableSensor() {
        sensor = false;
    }

    public boolean isSensorEnabled() {
        return sensor;
    }
}

class FanDevice implements Switchable, Schedulable {

    private boolean power;
    private boolean scheduled;

    public void turnOn() {
        power = true;
    }

    public void turnOff() {
        power = false;
    }

    public boolean isOn() {
        return power;
    }

    public void schedule() {
        scheduled = true;
        System.out.println("Fan scheduled");
    }

    public void cancelSchedule() {
        scheduled = false;
        System.out.println("Fan schedule canceled");
    }
}

class ThermostatDevice implements Switchable, SensorEnabled {

    private boolean power;
    private boolean sensor;

    public void turnOn() {
        power = true;
    }

    public void turnOff() {
        power = false;
    }

    public boolean isOn() {
        return power;
    }

    public void enableSensor() {
        sensor = true;
    }

    public void disableSensor() {
        sensor = false;
    }

    public boolean isSensorEnabled() {
        return sensor;
    }
}

class LightDevice implements Switchable, Schedulable {

    private boolean power;
    private boolean scheduled;

    public void turnOn() {
        power = true;
    }

    public void turnOff() {
        power = false;
    }

    public boolean isOn() {
        return power;
    }

    public void schedule() {
        scheduled = true;
        System.out.println("Light scheduled");
    }

    public void cancelSchedule() {
        scheduled = false;
        System.out.println("Light schedule canceled");
    }
}

public class Prac3_2 {

    public static void main(String[] args) {

        Switchable.safetyNotice(); 

        CameraDevice camera = new CameraDevice();
        FanDevice fan = new FanDevice();
        ThermostatDevice thermostat = new ThermostatDevice();
        LightDevice light = new LightDevice();

        camera.turnOn();
        camera.enableSensor();
        camera.displayPowerStatus();
        camera.displaySensorStatus();

        fan.turnOn();
        if (Schedulable.isValidHour(18)) {
            fan.schedule();
        }
        fan.displayPowerStatus();
        fan.displayScheduleInfo();

        thermostat.turnOn();
        thermostat.enableSensor();
        thermostat.displayPowerStatus();
        thermostat.displaySensorStatus();

        light.turnOn();
        light.schedule();
        light.displayPowerStatus();
        light.displayScheduleInfo();
    }
}
