class Solution {
    public int majorityElement(int[] nums) {
        int value=nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            int count= map.getOrDefault(num,0)+1;
            map.put(num,count);
            if(count>value)
                return num;
        }

        return -1;
    }
}