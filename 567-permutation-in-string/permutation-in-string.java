import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = len1;  // number of chars still needed

        while (right < len2) {
            char cRight = s2.charAt(right);
            if (map.containsKey(cRight)) {
                if (map.get(cRight) > 0) {
                    count--;
                }
                map.put(cRight, map.get(cRight) - 1);
            }
            right++;

            // When window size equals s1 length, check if permutation is found
            if (count == 0) {
                return true;
            }

            if (right - left == len1) {
                char cLeft = s2.charAt(left);
                if (map.containsKey(cLeft)) {
                    if (map.get(cLeft) >= 0) {
                        count++;
                    }
                    map.put(cLeft, map.get(cLeft) + 1);
                }
                left++;
            }
        }

        return false;
    }
}
