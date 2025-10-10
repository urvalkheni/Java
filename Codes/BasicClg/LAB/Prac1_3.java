import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface VehicleInfo {
    String value() default "";
    String category() default "General";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface VehicleType {
    String category();
    int maxCapacity() default 1;
}

final class VehicleUtils {
    public static void printVehicleInfo(Object obj) {
        Class<?> cls = obj.getClass();
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Vehicle Type: " + cls.getSimpleName());
        
        // Check class-level annotations
        if (cls.isAnnotationPresent(VehicleType.class)) {
            VehicleType vehicleType = cls.getAnnotation(VehicleType.class);
            System.out.println("Category: " + vehicleType.category());
            System.out.println("Max Capacity: " + vehicleType.maxCapacity());
        }
        
        System.out.println("Field Information:");
        System.out.println("-".repeat(30));
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(VehicleInfo.class)) {
                field.setAccessible(true);
                VehicleInfo info = field.getAnnotation(VehicleInfo.class);
                try {
                    System.out.printf("%-15s: %-15s [%s - %s]%n", 
                                    field.getName(), 
                                    field.get(obj), 
                                    info.value(),
                                    info.category());
                } catch (IllegalAccessException e) {
                    System.err.println("Error accessing field " + field.getName() + ": " + e.getMessage());
                }
            }
        }
    }

    public final void displayMessage() {
        System.out.println("🚗 Vehicle Registration Utility System 🚗");
    }
    
    public static void compareVehicles(Vehicle v1, Vehicle v2) {
        System.out.println("\nVehicle Comparison:");
        System.out.println("-".repeat(30));
        System.out.printf("%-10s vs %-10s%n", v1.getClass().getSimpleName(), v2.getClass().getSimpleName());
    }
}
}

class Vehicle {
    @VehicleInfo(value = "Unique Registration Number", category = "Legal")
    private final String regNo;
    
    @VehicleInfo(value = "Vehicle Color", category = "Appearance")
    private final String color;

    public Vehicle(String regNo) {
        this(regNo, "Unknown");
    }
    
    public Vehicle(String regNo, String color) {
        this.regNo = regNo;
        this.color = color;
    }

    public final void showRegistration() {
        System.out.printf("Registration: %s (Color: %s)%n", regNo, color);
    }
    
    public String getRegNo() { return regNo; }
    public String getColor() { return color; }
}

@VehicleType(category = "Personal Vehicle", maxCapacity = 5)
class Car extends Vehicle {
    @VehicleInfo(value = "Engine Type", category = "Technical")
    private final String engineType;
    
    public Car(String regNo) {
        this(regNo, "White", "Petrol");
    }
    
    public Car(String regNo, String color, String engineType) {
        super(regNo, color);
        this.engineType = engineType;
    }
    
    public String getEngineType() { return engineType; }
}

@VehicleType(category = "Two Wheeler", maxCapacity = 2)
class Bike extends Vehicle {
    @VehicleInfo(value = "Engine Capacity", category = "Technical")
    private final String engineCC;
    
    public Bike(String regNo) {
        this(regNo, "Black", "150cc");
    }
    
    public Bike(String regNo, String color, String engineCC) {
        super(regNo, color);
        this.engineCC = engineCC;
    }
    
    public String getEngineCC() { return engineCC; }
}

@VehicleType(category = "Commercial Vehicle", maxCapacity = 3)
class Truck extends Vehicle {
    @VehicleInfo(value = "Load Capacity", category = "Commercial")
    private final String loadCapacity;
    
    public Truck(String regNo) {
        this(regNo, "Yellow", "10 Tons");
    }
    
    public Truck(String regNo, String color, String loadCapacity) {
        super(regNo, color);
        this.loadCapacity = loadCapacity;
    }
    
    public String getLoadCapacity() { return loadCapacity; }
}

public class Prac1_3 {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Registration System ===");
        
        VehicleUtils utils = new VehicleUtils();
        utils.displayMessage();

        Car car = new Car("GJ01AB1234", "Red", "Diesel");
        Bike bike = new Bike("GJ05CD5678", "Blue", "200cc");
        Truck truck = new Truck("GJ12EF9101", "Yellow", "15 Tons");

        // Display detailed vehicle information using reflection
        VehicleUtils.printVehicleInfo(car);
        VehicleUtils.printVehicleInfo(bike);
        VehicleUtils.printVehicleInfo(truck);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Registration Details:");
        System.out.println("-".repeat(30));
        car.showRegistration();
        bike.showRegistration();
        truck.showRegistration();

        // Compare vehicles
        VehicleUtils.compareVehicles(car, bike);
        VehicleUtils.compareVehicles(bike, truck);

        System.out.println("\n24CE055 <--> Urval Kheni");
    }
}
