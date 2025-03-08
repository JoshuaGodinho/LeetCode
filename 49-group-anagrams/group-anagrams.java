import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort each string
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            
            // Group by sorted key
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        
        // Return all the grouped values
        return new ArrayList<>(map.values());
    }
}
