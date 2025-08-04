package Codes.BasicClg.LAB.Practicallist.Prac3;

public class Prac_3_1 {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System ===");
        System.out.println("Demonstrating Inheritance and Polymorphism\n");
        
        // 1. Creating different types of staff
        System.out.println("=== Creating Staff Members ===");
        Doctors doctor1 = new Doctors("Dr. Smith", 101, "Cardiology", 80000, "Cardiologist", "MD12345", "MD");
        Nurses nurse1 = new Nurses("Sarah Johnson", 201, "Emergency", 50000, "Emergency Care", "BSc Nursing", "Night");
        Administrative_Staff admin1 = new Administrative_Staff("Mike Wilson", 301, "Administration", 45000, "Receptionist", "Front Desk");
        
        // 2. Demonstrating Runtime Polymorphism
        System.out.println("\n=== Runtime Polymorphism ===");
        Staff[] staffArray = {doctor1, nurse1, admin1};
        
        for (Staff staff : staffArray) {
            System.out.println("Calling work() method:");
            staff.work(); // Runtime polymorphism - calls appropriate work() method
            System.out.println();
        }
        
        // 3. Demonstrating Upcasting
        System.out.println("=== Upcasting ===");
        Staff upcastedDoctor = doctor1; // Upcasting
        Staff upcastedNurse = nurse1;   // Upcasting
        Staff upcastedAdmin = admin1;   // Upcasting
        
        System.out.println("Upcasted objects calling work():");
        upcastedDoctor.work();
        upcastedNurse.work();
        upcastedAdmin.work();
        System.out.println();
        
        // 4. Demonstrating Downcasting
        System.out.println("=== Downcasting ===");
        if (upcastedDoctor instanceof Doctors) {
            Doctors downcastedDoctor = (Doctors) upcastedDoctor; // Downcasting
            downcastedDoctor.prescribeMedicine(); // Access to Doctors-specific method
        }
        
        if (upcastedNurse instanceof Nurses) {
            Nurses downcastedNurse = (Nurses) upcastedNurse; // Downcasting
            downcastedNurse.administerMedication(); // Access to Nurses-specific method
        }
        
        if (upcastedAdmin instanceof Administrative_Staff) {
            Administrative_Staff downcastedAdmin = (Administrative_Staff) upcastedAdmin; // Downcasting
            downcastedAdmin.handleAppointments(); // Access to Admin-specific method
        }
        System.out.println();
        
        // 5. Demonstrating Constructor Chaining with super()
        System.out.println("=== Constructor Chaining ===");
        Doctors doctor2 = new Doctors(); // Uses constructor chaining
        Nurses nurse2 = new Nurses();    // Uses constructor chaining
        Administrative_Staff admin2 = new Administrative_Staff(); // Uses constructor chaining
        
        System.out.println("Default constructed objects:");
        doctor2.displayInfo();
        System.out.println();
        nurse2.displayInfo();
        System.out.println();
        admin2.displayInfo();
        System.out.println();
        
        // 6. Comprehensive Display
        System.out.println("=== Complete Staff Information ===");
        for (Staff staff : staffArray) {
            staff.displayInfo();
            System.out.println("---");
        }
        
        // 7. Demonstrating specific duties
        System.out.println("=== Specific Duties ===");
        doctor1.prescribeMedicine();
        nurse1.administerMedication();
        admin1.manageRecords();
    }
}
