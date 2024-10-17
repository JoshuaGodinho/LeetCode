class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] result=new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int pos = map.get(nums1[i]); // Get the position of nums1[i] in nums2
            
            boolean found=false;
            for(int j=pos+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    result[i]=nums2[j];
                    found=true;
                    break;
                }             
            }
            if(found==false)
                result[i]=-1;
        }
        return result;
    }
}