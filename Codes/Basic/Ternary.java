public class Ternary {
    public static void main(String[] args) {
        int a = 55;
        String result = ((a & 1) == 1) ? "Odd" : "Even";
        System.out.println(result);
    }
}
