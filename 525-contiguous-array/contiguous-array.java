import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> prefixSumMap=new HashMap<>();
        int maxLength=0;
        int prefixSum=0;

        prefixSumMap.put(0,-1);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                prefixSum+=-1;
            else
                prefixSum+=1;

            if(prefixSumMap.containsKey(prefixSum)){
                int prevIndex=prefixSumMap.get(prefixSum);
                maxLength=Math.max(maxLength,i-prevIndex);
            }else{
                prefixSumMap.put(prefixSum,i);
            }
        }
        return maxLength;
    }
}