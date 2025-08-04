package Codes.BasicClg.LAB.Practicallist.Prac3;

public class Administrative_Staff extends Staff {
    private String role;
    private String officeLocation;
    
    public Administrative_Staff() {
        super();
        this.role = "General Admin";
        this.officeLocation = "Main Office";
    }
    
    public Administrative_Staff(String name, int id, String department, double salary, String role) {
        super(name, id, department, salary);
        this.role = role;
        this.officeLocation = "Main Office";
    }
    
    public Administrative_Staff(String name, int id, String department, double salary, String role, String officeLocation) {
        super(name, id, department, salary);
        this.role = role;
        this.officeLocation = officeLocation;
    }
    
    @Override
    public void work() {
        super.work(); // Call parent class work method using super
        System.out.println(name + " is performing administrative tasks in " + role + " role");
        System.out.println(name + " is managing hospital records and documentation");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent class displayInfo method using super
        System.out.println("Role: " + role);
        System.out.println("Office Location: " + officeLocation);
    }
    
    public void manageRecords() {
        System.out.println(name + " is managing hospital records and documentation");
    }
    
    public void handleAppointments() {
        System.out.println(name + " is scheduling and managing patient appointments");
    }
    
    public String getRole() { return role; }
    public String getOfficeLocation() { return officeLocation; }
} 