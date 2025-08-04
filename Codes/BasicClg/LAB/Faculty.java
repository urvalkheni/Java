package Codes.BasicClg.LAB;

public class Faculty extends Institute {
    String fID;
    String fName;
    String department;
    
    public Faculty() {
        super(); // Call parent class default constructor
        System.err.println("Faculty class created");
    }
    
    public Faculty(String fID, String fName, String department) {
        super(); // Call parent class default constructor
        this.fID = fID;
        this.fName = fName;
        this.department = department;
    }
    
    public Faculty(int icode, String fID, String fName, String department) {
        super(icode); // Call parent class constructor with icode
        this.fID = fID;
        this.fName = fName;
        this.department = department;
    }
    
    public Faculty(int icode, String iname, String fID, String fName, String department) {
        super(icode, iname); // Call parent class constructor with icode and iname
        this.fID = fID;
        this.fName = fName;
        this.department = department;
    }
    
    void displayFaculty() {
        System.out.println("Faculty ID: " + fID);
        System.out.println("Faculty Name: " + fName);
        System.out.println("Department: " + department);
        display(); // Call parent class display method
    }
}
