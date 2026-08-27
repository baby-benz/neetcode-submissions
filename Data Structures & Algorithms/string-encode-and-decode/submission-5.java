class Solution {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < str.length()) {
            int curLen = Character.getNumericValue(str.charAt(i));
            i++;
            while (Character.isDigit(str.charAt(i))) {
                curLen *= 10;
                curLen += Character.getNumericValue(str.charAt(i));
                i++;
            }
            i++;
            result.add(str.substring(i, i + curLen));
            i += curLen;
        }
        
        return result;
    }
}
