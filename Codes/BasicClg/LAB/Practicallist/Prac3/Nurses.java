package Codes.BasicClg.LAB.Practicallist.Prac3;

public class Nurses extends Staff {
    private String specialization;
    private String nursingDegree;
    private String shift;
    
    public Nurses() {
        super();
        this.specialization = "General Nursing";
        this.nursingDegree = "BSc Nursing";
        this.shift = "Day";
    }
    
    public Nurses(String name, int id, String department, double salary, String specialization) {
        super(name, id, department, salary);
        this.specialization = specialization;
        this.nursingDegree = "BSc Nursing";
        this.shift = "Day";
    }
    
    public Nurses(String name, int id, String department, double salary, String specialization, String nursingDegree, String shift) {
        super(name, id, department, salary);
        this.specialization = specialization;
        this.nursingDegree = nursingDegree;
        this.shift = shift;
    }
    
    @Override
    public void work() {
        super.work(); // Call parent class work method using super
        System.out.println(name + " is providing patient care and monitoring vital signs in " + specialization);
        System.out.println(name + " is working " + shift + " shift and providing nursing care");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent class displayInfo method using super
        System.out.println("Specialization: " + specialization);
        System.out.println("Nursing Degree: " + nursingDegree);
        System.out.println("Shift: " + shift);
    }
    
    public void administerMedication() {
        System.out.println(name + " is administering medication to patients");
    }
    
    public String getSpecialization() { return specialization; }
    public String getNursingDegree() { return nursingDegree; }
    public String getShift() { return shift; }
} 