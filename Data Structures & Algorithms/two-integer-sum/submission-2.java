class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int secondNum = target - curNum;
            if (numsMap.containsKey(secondNum)) {
                return new int[]{numsMap.get(secondNum), i};
            }
            numsMap.put(curNum, i);
        }

        return new int[]{};
    }
}
