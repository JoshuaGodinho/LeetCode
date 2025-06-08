class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq=new HashMap<>();
        HashMap<Integer, Integer> firstIndex=new HashMap<>();
        HashMap<Integer,Integer> lastIndex=new HashMap<>();

        int degree=0;
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            freq.put(num, freq.getOrDefault(num,0)+1);
            firstIndex.putIfAbsent(num,i);
            lastIndex.put(num,i);

            degree=Math.max(degree,freq.get(num));
        }
        int minLen=nums.length;
        for(int num:freq.keySet())
        {
            if(freq.get(num)==degree)
            {
                minLen=Math.min(minLen, lastIndex.get(num)-firstIndex.get(num)+1);
            }
        } 
        return minLen;       
    }
}