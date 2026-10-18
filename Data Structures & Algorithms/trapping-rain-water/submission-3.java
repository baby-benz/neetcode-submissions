class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > maxLeft[i - 1]) {
                maxLeft[i] = height[i - 1];
            } else {
                maxLeft[i] = maxLeft[i - 1];
            }
        }

        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > maxRight[i + 1]) {
                maxRight[i] = height[i + 1];
            } else {
                maxRight[i] = maxRight[i + 1];
            }
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (temp > 0) result += temp;
        }
        return result;
    }
}
