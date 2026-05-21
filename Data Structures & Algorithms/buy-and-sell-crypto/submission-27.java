class Solution {
    public int maxProfit(int[] prices) {
        int lpointer = 0;
        int max = Integer.MIN_VALUE;
        for (int rpointer = 0; rpointer < prices.length; rpointer ++) {
            if (prices[rpointer] < prices[lpointer]) {
                lpointer = rpointer;
            }
            max = Math.max(max, prices[rpointer] - prices[lpointer]);
        }
        return max;
     }
}
