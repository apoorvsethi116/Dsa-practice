package Recursion;

public class Fibonacci {


        public static int fib(int n) {
            // f(n) = f(n-1) + f(n_2);
            if(n == 0){
                return 0;
            }if(n==1){
                return 1;
            }
            int res = fib(n-1) + fib(n-2);
            return res;

        }
        public static void main(String[] args) {
            System.out.print(fib(3));
        }
    }

