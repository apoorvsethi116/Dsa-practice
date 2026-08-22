class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        String s = Integer.toString(n);
        for(int i = 0; i<s.length(); i++){
            int a = s.charAt(i) - '0';
            sum += a;
            prod *= a;

        }

        int all = sum + prod;
        if(n%all != 0){
            return false;
        }

        return true;
    }
}