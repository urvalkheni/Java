package Codes.BasicClg.LAB.Practicallist.Prac3;

public class Doctors extends Staff {
    private String specialization;
    private String licenseNumber;
    private String medicalDegree;
    
    public Doctors() {
        super();
        this.specialization = "General Medicine";
        this.licenseNumber = "Unknown";
        this.medicalDegree = "MBBS";
    }
    
    public Doctors(String name, int id, String department, double salary, String specialization) {
        super(name, id, department, salary);
        this.specialization = specialization;
        this.licenseNumber = "Unknown";
        this.medicalDegree = "MBBS";
    }
    
    public Doctors(String name, int id, String department, double salary, String specialization, String licenseNumber, String medicalDegree) {
        super(name, id, department, salary);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.medicalDegree = medicalDegree;
    }
    
    @Override
    public void work() {
        super.work(); // Call parent class work method using super
        System.out.println(name + " is diagnosing and treating patients in " + specialization);
        System.out.println(name + " is conducting medical consultations and surgeries");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent class displayInfo method using super
        System.out.println("Specialization: " + specialization);
        System.out.println("License Number: " + licenseNumber);
        System.out.println("Medical Degree: " + medicalDegree);
    }
    
    public void prescribeMedicine() {
        System.out.println(name + " is prescribing medicine to patients");
    }
    
    public String getSpecialization() { return specialization; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getMedicalDegree() { return medicalDegree; }
}
