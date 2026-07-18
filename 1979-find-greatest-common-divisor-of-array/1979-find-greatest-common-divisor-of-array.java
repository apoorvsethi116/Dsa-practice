class Solution {
    public int gcd(int a , int b){
        return (b==0) ? a : gcd(b , a%b);
    }
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        return gcd(min, max);

    }
}