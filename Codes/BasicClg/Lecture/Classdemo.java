package Codes.BasicClg.Lecture;
class test{
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
        test t = new test();
        t.a=9;
        t.b=6;
        System.out.println(t.sum(t.a,t.b));
    }
}