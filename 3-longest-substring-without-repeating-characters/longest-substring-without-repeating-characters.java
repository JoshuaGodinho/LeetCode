class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char currentChar=s.charAt(right);
            if(map.containsKey(currentChar)){
                left=Math.max(map.get(currentChar)+1,left);
            }
            map.put(currentChar,right);
            count=Math.max(count, right-left+1);
        }

        return count;
    }
}