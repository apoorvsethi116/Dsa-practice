class Solution {
    public int fib1(int n){
        if(n==0 || n==1){
            return n;
        }

        return fib1(n-1) + fib1(n-2);
    }
    public int fib(int n) {
        // int[] f = new int[n+1];
        return fib1(n);
    }
}