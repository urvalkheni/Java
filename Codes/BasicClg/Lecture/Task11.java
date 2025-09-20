
import java.util.Scanner;
enum FuelType {
    F95, F98, DIESEL
}

class GasMeter {
    private static double totalF95 = 0;
    private static double totalF98 = 0;
    private static double totalDiesel = 0;

    public void refuel(FuelType type, double liters) {
        switch (type) {
            case F95:
                totalF95 += liters;
                break;
            case F98:
                totalF98 += liters;
                break;
            case DIESEL:
                totalDiesel += liters;
                break;
        }
    }

    public static void printF95Used() {
        System.out.println("F95 used: " + totalF95 + " liters");
    }

    public static void printF98Used() {
        System.out.println("F98 used: " + totalF98 + " liters");
    }

    public static void printDieselUsed() {
        System.out.println("Diesel used: " + totalDiesel + " liters");
    }

    public static void printTotalUsed() {
        double total = totalF95 + totalF98 + totalDiesel;
        System.out.println("Total fuel used: " + total + " liters");
    }
}

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GasMeter meter = new GasMeter();
        while (true) {
            System.out.println("Choose fuel type to refuel:");
            System.out.println("1. F95");
            System.out.println("2. F98");
            System.out.println("3. Diesel");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            FuelType type = null;
            switch (choice) {
                case 1:
                    type = FuelType.F95;
                    break;
                case 2:
                    type = FuelType.F98;
                    break;
                case 3:
                    type = FuelType.DIESEL;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            System.out.print("Enter amount in liters: ");
            double liters = scanner.nextDouble();
            meter.refuel(type, liters);
        }
        GasMeter.printF95Used();
        GasMeter.printF98Used();
        GasMeter.printDieselUsed();
        GasMeter.printTotalUsed();
        scanner.close();
    }
}