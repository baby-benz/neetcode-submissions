class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int minLeft = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minLeft = Math.min(minLeft, prices[i - 1]);
            maxProfit = Math.max(maxProfit, prices[i] - minLeft);
        }

        return maxProfit;
    }
}
