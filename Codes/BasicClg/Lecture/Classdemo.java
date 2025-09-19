
class Test{
    int a;
    int b;
    int sum(int a,int b)
    {
        return a+b;
    }
}
public class Classdemo 
{
    public static void main(String a[])
    {
        Test t = new Test();
        t.a=9;
        t.b=6;
        System.out.println(t.sum(t.a,t.b));
    }
}