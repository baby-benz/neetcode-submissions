class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int[] minLeft = new int[prices.length];
        minLeft[0] = Integer.MAX_VALUE;

        for (int i = 1; i < prices.length; i++) {
            minLeft[i] = Math.min(minLeft[i - 1], prices[i - 1]);
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minLeft[i]);
        }

        return maxProfit;
    }
}
