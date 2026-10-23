class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int left = 0;
        int right = left + 1;
        int result = 0;

        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            } else {
                int temp = prices[right] - prices[left];
                if (temp > result) result = temp;
            }
            right++;
        }

        return result;
    }
}
