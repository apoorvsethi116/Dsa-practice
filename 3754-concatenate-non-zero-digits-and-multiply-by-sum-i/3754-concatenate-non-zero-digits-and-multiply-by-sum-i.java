class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ab = new StringBuilder();
        int sum = 0;
        sb.append(n);
        for(int i = 0; i<sb.length(); i++){
            if(sb.charAt(i) != '0'){
                
                ab.append(sb.charAt(i));

                sum += (sb.charAt(i) - '0');
            }
        }

         if (ab.length() == 0) {
            return 0;
        }

       long a = Long.parseLong(ab.toString());
       return a*sum;
    }
}