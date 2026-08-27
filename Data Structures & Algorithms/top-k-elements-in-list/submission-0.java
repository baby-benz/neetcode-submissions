class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.merge(nums[i], 1, Integer::sum);
        }
        Queue<Integer> numsQueue = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        for (Integer num : countMap.keySet()) {
            numsQueue.add(num);
            if (numsQueue.size() > k) numsQueue.poll();
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = numsQueue.poll();
        }
        return result;
    }
}
