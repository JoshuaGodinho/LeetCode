class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Set<Character> charSet = new HashSet<>();

        while (end < n) {
            char currentChar = s.charAt(end);
            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }
}