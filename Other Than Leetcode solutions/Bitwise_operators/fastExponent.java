package Bitwise_operators;

import java.util.Scanner;

public class fastExponent {

    public static int fastPower(int a, int n){

        int result = 1;

        while(n > 0){

            // check if n is odd
            if((n & 1) == 1){
                result = result * a;
            }

            // square the base
            a = a * a;

            // divide exponent by 2
            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(fastPower(a, n));
    }
}