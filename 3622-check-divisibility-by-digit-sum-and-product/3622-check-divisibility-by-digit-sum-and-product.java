class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int org = n;
        
        while(n>0){
            int a = n%10;
            sum+=a;
            prod*=a;

            n = n/10;
        }
        int all = sum + prod;
        if(org%all != 0){
            return false;
        }

        return true;
    }
}