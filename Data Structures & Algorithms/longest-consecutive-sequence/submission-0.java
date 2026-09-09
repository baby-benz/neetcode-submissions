class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSequenceSize = 0;
        for (Integer num : numSet) {
            if (numSet.contains(num - 1)) continue;
            int curNum = num;
            int curSequenceSize = 1;
            while (numSet.contains(curNum + 1)) {
                curSequenceSize++;
                curNum++;
            }
            if (curSequenceSize > longestSequenceSize) {
                longestSequenceSize = curSequenceSize;
            }
        }

        return longestSequenceSize;
    }
}
