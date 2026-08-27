class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.merge(nums[i], 1, Integer::sum);
        }
        
        List<Integer>[] numsCount = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Integer count = entry.getValue();
            if (numsCount[count] == null) numsCount[count] = new ArrayList<>();
            numsCount[count].add(entry.getKey());
        }
        int[] result = new int[k];
        int processedElements = 0;
        for (int i = numsCount.length - 1; i >= 0 ; i--) {
            List<Integer> curCount = numsCount[i];
            if (curCount == null) continue;
            for (int count : curCount) {
                result[processedElements++] = count;
                if (processedElements == k) return result;
            }
        }
        return result;
    }
}
