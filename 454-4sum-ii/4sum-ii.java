class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int n1:nums1){
            for(int n2:nums2)
                map.put(n1+n2,map.getOrDefault(n1+n2,0)+1);
        }

        for(int n1:nums3){
            for(int n2:nums4)
                count+=map.getOrDefault(-(n1+n2),0);
        }

        return count;        
    }
}