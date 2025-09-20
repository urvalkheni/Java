package Codes.Basic;
public class NewSwitch {
    public static void main(String[] args) {
        String day = "Monday";

        // Using switch as an expression
        String typeOfDay = switch (day) {
            case "Saturday", "Sunday" -> "Weekend";
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            default -> "Invalid day";
        };

        System.out.println(day + " is a " + typeOfDay);
    }
}
