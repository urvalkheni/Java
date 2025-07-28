// package Codes.BasicClg.Lecture;

interface A {
    void methodA(int a);
}

interface B extends A {
    void methodB(float b);
}

interface C extends A {
    void methodC(double c);
}

interface D extends B, C {
    void methodD(long d);
}

class E implements D {
    private int a;
    private float b;
    private double c;
    private long d;
    @Override
    public void methodA(int a) {
        this.a = a;
    }
    @Override
    public void methodB(float b) {
        this.b = b;
    }
    @Override
    public void methodC(double c) {
        this.c = c;
    }
    @Override
    public void methodD(long d) {
        this.d = d;
    }
    public void calculate() {
        double result = a * b * c * d;
        System.out.println("Result of a * b * c * d = " + result);
    }
}

public class Task7 {
    public static void main(String[] args) {
        E obj = new E();
        obj.methodA(20);     
        obj.methodB(12.5f);  
        obj.methodC(12.5);   
        obj.methodD(50L);            
        obj.calculate();    
    }
}