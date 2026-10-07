class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int curMax = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = curMax;
            if (height[i] > curMax) {
                curMax = height[i];
            }
        }

        curMax = 0;
        for (int i = height.length - 1; i > 0; i--) {
            maxRight[i] = curMax;
            if (height[i] > curMax) {
                curMax = height[i];
            }
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int curResult = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (curResult > 0) result += curResult;
        }

        return result;
    }
}
