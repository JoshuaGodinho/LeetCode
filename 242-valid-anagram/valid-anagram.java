class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        HashMap<Character, Integer> map1=new HashMap<>();
        for(char c:t.toCharArray()){
            if(map1.containsKey(c))
                map1.put(c,map1.get(c)+1);
            else
                map1.put(c,1);
        }

        if(map.equals(map1))
            return true;
        else
            return false;
    }
}