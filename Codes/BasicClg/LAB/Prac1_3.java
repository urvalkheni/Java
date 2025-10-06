import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface VehicleInfo {
    String value() default "";
}

final class VehicleUtils {
    public static void printVehicleInfo(Object obj) {
        Class<?> cls = obj.getClass();
        System.out.println("Vehicle Type: " + cls.getSimpleName());
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(VehicleInfo.class)) {
                field.setAccessible(true);
                try {
                    System.out.println(field.getName() + ": " + field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void displayMessage() {
        System.out.println("Vehicle Registration Utility");
    }
}

class Vehicle {
    @VehicleInfo("Unique Registration Number")
    private final String regNo;

    public Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public final void showRegistration() {
        System.out.println("Registration Number: " + regNo);
    }
}

class Car extends Vehicle {
    public Car(String regNo) {
        super(regNo);
    }
}

class Bike extends Vehicle {
    public Bike(String regNo) {
        super(regNo);
    }
}

class Truck extends Vehicle {
    public Truck(String regNo) {
        super(regNo);
    }
}

public class Prac1_3 {
    public static void main(String[] args) {
        Car car = new Car("CAR1234");
        Bike bike = new Bike("BIKE5678");
        Truck truck = new Truck("TRUCK9101");

        VehicleUtils.printVehicleInfo(car);
        VehicleUtils.printVehicleInfo(bike);
        VehicleUtils.printVehicleInfo(truck);

        car.showRegistration();
        bike.showRegistration();
        truck.showRegistration();

        System.out.println("24CE055<-->Urval Kheni");
    }
}
