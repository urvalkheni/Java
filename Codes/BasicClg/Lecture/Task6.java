// package Codes.BasicClg.Lecture;
interface Exam{
    boolean pass(int mark);
}
interface Classify{
    String division(int mark);
}
class Marks implements Exam, Classify {
    @Override
    public boolean pass(int mark) {
        return mark >= 50;
    }

    @Override
    public String division(int mark) {
        if (mark >= 60) {
            return "First Division";
        } else if (mark >= 50) {
            return "Second Division";
        }else {
            return "No Division";
        }
    }
}
public class Task6 {
    public static void main(String[] args) {
        Marks marks = new Marks();
        int mark = 35;
        System.out.println("Mark: " + mark);
        System.out.println("Pass: " + marks.pass(mark));
        System.out.println("Division: " + marks.division(mark));
    }
}
