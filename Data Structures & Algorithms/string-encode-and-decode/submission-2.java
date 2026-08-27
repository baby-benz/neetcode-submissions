class Solution {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append(',');
        }

        sb.replace(sb.length() - 1, sb.length(), "|");

        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<Integer> lengths = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int curLen = Character.getNumericValue(str.charAt(i));
            i++;
            while (Character.isDigit(str.charAt(i))) {
                curLen *= 10;
                curLen += Character.getNumericValue(str.charAt(i));
                i++;
            }
            lengths.add(curLen);
            if (str.charAt(i) == '|') {
                break;
            }
            i++;
        }
        i++;
        List<String> result = new ArrayList<>();
        for (int j = 0; j < lengths.size(); j++) {
            int curLen = lengths.get(j);
            result.add(str.substring(i, i + curLen));
            i += curLen;
        }
        return result;
    }
}
