// First Calss Interest Calculate
// Max out of three number
package Codes.OOPS;
class Interest{
    int principalAmount;
    float rate;
    float time;
    float interest(int principalAmount,float rate,float time){
        float SI;
        SI = (principalAmount*rate*time)/100;
        return SI;
    }
}
class Max{
    int a,b,c;
    int max(int a,int b,int c){
        if(a>b && a>c){
            return a;
        }
         else if(b>a && b>c){
            return b;
        }
        else{
            return c;
        }
    }

}
public class Task {
    public static void main(String[] args){
        Interest I = new Interest();
        I.principalAmount = 1000;
        I.rate = 1.2f;
        I.time = 5f;
        System.out.println(I.interest(I.principalAmount,I.rate,I.time));
        Max M  = new Max();
        M.a = 10;
        M.b = 1;
        M.c = 5;
        System.out.println(M.max(M.a,M.b,M.c)); 
    }
}
