import java.util.*;
class Solution {
    public int gcd(int a , int b){
        return (b==0) ? a : gcd(b , a%b); 
    }
    public int gcdOfOddEvenSums(int n) {
        return gcd(n*n , n*(n+1));
    }
}