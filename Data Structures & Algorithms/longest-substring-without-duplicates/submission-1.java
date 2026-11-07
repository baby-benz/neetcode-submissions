class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> metChars = new HashMap<>();

        int left = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer lastMetIdx = metChars.get(s.charAt(i));
            if (lastMetIdx == null || lastMetIdx < left) {
                int cur = i - left + 1;
                if (cur > result) result = cur;
            } else {
                left = lastMetIdx + 1;
            }
            metChars.put(s.charAt(i), i);
        }

        return result;
    }
}
