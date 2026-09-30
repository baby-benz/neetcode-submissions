class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int volume = height * (right - left);
            maxWater = Math.max(maxWater, volume);
            if (heights[left] > heights[right]) {
                right--;
            } else if (heights[right] > heights[left]) {
                left++;
            } else {
                right--;
                left++;
            }
        }

        return maxWater;
    }
}
