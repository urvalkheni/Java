

public class Ifelseif {
    public static void main(String[] args) {
        int x = 10,y=7,z=5;
        if(x>y && x>z){
            System.out.println("x is the largest");
        }else if(y>x && y>z){
            System.out.println("y is the largest");
        }else{
            System.out.println("z is the largest");
        }
    }
}
