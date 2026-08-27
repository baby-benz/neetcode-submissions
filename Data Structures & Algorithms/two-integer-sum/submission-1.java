class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int secondNum = target - curNum;
            Integer secondNumIdx = numsMap.get(secondNum);
            if (secondNumIdx != null) {
                return new int[]{secondNumIdx, i};
            }
            numsMap.put(curNum, i);
        }

        return new int[]{};
    }
}
