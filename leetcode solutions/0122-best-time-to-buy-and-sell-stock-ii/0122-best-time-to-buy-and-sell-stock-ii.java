class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        int i = 0;
        int j = 1;

        while(j<prices.length){
            if(prices[j] > prices[i]){
                profit += prices[j] - prices[i];
               
            }

            i++;
            j++;

        }
        

        return profit;
    }
}