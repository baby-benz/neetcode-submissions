class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCharCount[s.charAt(i) - 'a']++;
            tCharCount[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sCharCount, tCharCount);
    }
}
