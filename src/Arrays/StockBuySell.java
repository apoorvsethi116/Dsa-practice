package Arrays;
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock
//and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction.
//If you cannot achieve any profit, return 0.
public class StockBuySell {
    public static int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            int val = prices[i];
            mini = Math.min(mini, val);
            maxProfit = Math.max(maxProfit, val - mini);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {123,133,111,143,134,122};
        System.out.println(maxProfit(prices));
    }
}

