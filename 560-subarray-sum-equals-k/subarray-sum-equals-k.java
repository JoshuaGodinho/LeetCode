class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        prefixSumMap.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for(int num:nums){
            prefixSum+=num;

            if(prefixSumMap.containsKey(prefixSum-k)){
                count+=prefixSumMap.get(prefixSum-k);
            }

            prefixSumMap.put(prefixSum,prefixSumMap.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}