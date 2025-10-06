abstract class Staff {
    String name;
    int id;

    Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract void work();
}

abstract class MedicalStaff extends Staff {
    MedicalStaff(String name, int id) {
        super(name, id);
    }
}

class Doctor extends MedicalStaff {
    String specialization;

    Doctor(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }

    @Override
    void work() {
        System.out.println("Dr. " + name + " (Specialist in " + specialization + ") is diagnosing patients.");
    }

    void prescribeMedicine() {
        System.out.println("Dr. " + name + " is prescribing medicine.");
    }
}

class Nurse extends MedicalStaff {
    Nurse(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Nurse " + name + " is assisting in operations and patient care.");
    }
}

class AdminStaff extends Staff {
    AdminStaff(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Admin " + name + " is managing hospital records and schedules.");
    }
}

final class FinanceTeam extends Staff {
    FinanceTeam(String name, int id) {
        super(name, id);
    }

    @Override
    void work() {
        System.out.println("Finance team member " + name + " is handling hospital accounts.");
    }
}

public class Prac3_1 {
    public static void main(String[] args) {
        Staff s1 = new Doctor("Krish", 101, "Cardiology");
        Staff s2 = new Nurse("Pushti", 102);
        Staff s3 = new AdminStaff("Urval", 103);
        Staff s4 = new FinanceTeam("Heet", 104);

        s1.work();
        s2.work();
        s3.work();
        s4.work();

        if (s1 instanceof Doctor) {
            Doctor d = (Doctor) s1;
            d.prescribeMedicine();
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
