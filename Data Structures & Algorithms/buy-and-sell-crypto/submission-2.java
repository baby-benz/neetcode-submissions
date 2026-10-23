class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int left = 0;
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[left]) {
                left = i;
            } else {
                int temp = prices[i] - prices[left];
                if (temp > result) result = temp;
            }
        }

        return result;
    }
}
