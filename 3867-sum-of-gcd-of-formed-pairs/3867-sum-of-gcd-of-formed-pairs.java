class Solution {
    public int gcd(int a , int b){
        return (b == 0) ? a : gcd(b , a%b);
    }
    public long gcdSum(int[] nums) {
        
        int[] prefixGcd = new int[nums.length];

        int currMax = 0;
        for(int i = 0; i<nums.length; i++){
            currMax = Math.max(currMax , nums[i]);
            prefixGcd[i] = gcd(nums[i] , currMax);
        }

    

        Arrays.sort(prefixGcd);

        int n = prefixGcd.length;
        long sum = 0;
        for(int i = 0; i<n/2; i++){
            sum += (long)gcd(prefixGcd[i] , prefixGcd[n-i - 1]);
        }

        return sum;
    }
}