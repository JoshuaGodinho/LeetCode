class Solution {
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0 ||k>s.length())
            return 0;
        
        return longestSubStringHelper(s,k,0,s.length());
    }

    public int longestSubStringHelper(String s,int k,int start, int end){
        if(end-start<k)
            return 0;
        
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=start;i<end;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=start;i<end;i++){
            if(map.get(s.charAt(i))<k){
                int leftPart=longestSubStringHelper(s,k,start,i);
                int rightPart=longestSubStringHelper(s,k,i+1,end);
                return Math.max(leftPart,rightPart);
            }
        }
        return end-start;
    }
}