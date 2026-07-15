import java.util.*;
class Solution {
    public int gcd(int a , int b){
        return (b==0) ? a : gcd(b , a%b); 
    }
    public int gcdOfOddEvenSums(int n) {
        int[] sumOdd = new int[n];
        int[] sumEven = new int[n];

        sumOdd[0] = 1;
        sumEven[0] = 2;

        for(int i = 1; i<n; i++){
            sumOdd[i] = sumOdd[i-1] + 2;
            sumEven[i] = sumEven[i-1] + 2;
            
        }

        int sum1 = 0; //even
        int sum2 = 0; //odd
        for(int i = 0; i<sumEven.length; i++){
            sum1 += sumEven[i];
            sum2 += sumOdd[i];
        }

        int res = gcd(sum1 , sum2);
        return res;
    }
}