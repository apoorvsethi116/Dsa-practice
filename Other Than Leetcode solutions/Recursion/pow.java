package Recursion;

public class pow {
    public static int betterPow(int a , int n){
        if(n == 0 ){
            return 1;
        }
        int half = betterPow(a , (n)/2);
        if((n & 1) != 0){
            return a * half * half;
        }else{
            return half * half;
        }
    }
    public static int pow(int a , int n){
        if(n == 0){
            return 1;
        }
        return a * pow(a , n-1);
    }

    public static void main(String args[]){
        int a = 3;
        int n = 5;
        System.out.println(betterPow(a, n));
    }
}
