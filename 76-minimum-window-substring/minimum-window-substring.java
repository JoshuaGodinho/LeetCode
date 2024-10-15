class Solution {
    public String minWindow(String s, String t) {
        if(s==null || s.length()==0 || t==null || t.length()==0)
            return "";

        HashMap<Character, Integer> tmap=new HashMap<>();
        for(char c:t.toCharArray())
            tmap.put(c,tmap.getOrDefault(c,0)+1);

        HashMap<Character, Integer> windowMap=new HashMap<>();
        int left=0;int right=0;
        int required=tmap.size();
        int formed=0;
        int count=Integer.MAX_VALUE;
        int start=0;

        while(right<s.length()){
            char c=s.charAt(right);
            windowMap.put(c,windowMap.getOrDefault(c,0)+1);

            if(tmap.containsKey(c) && windowMap.get(c).intValue()==tmap.get(c).intValue())
                formed++;

            while(left<=right && formed==required){
                if(right-left+1<count){
                    count=right-left+1;
                    start=left;
                }
            
            char leftChar=s.charAt(left);
            windowMap.put(leftChar,windowMap.get(leftChar)-1);

            if(tmap.containsKey(leftChar) && windowMap.get(leftChar).intValue()<tmap.get(leftChar).intValue())
                formed--;

            left++;
            }
            right++;
        }

        return count==Integer.MAX_VALUE?"":s.substring(start,start+count);
    }
}