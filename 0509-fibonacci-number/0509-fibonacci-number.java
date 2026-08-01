class Solution {
    public int fib1(int n , int[] f){
        if(n==0 || n==1){
            return n;
        }

        if(f[n] != 0){
            return f[n];
        }

        f[n] = fib1(n-1 , f) + fib1(n-2 , f);
        return f[n];
    }
    public int fib(int n) {
        int[] f = new int[n+1];
        return fib1(n , f);
    }
}