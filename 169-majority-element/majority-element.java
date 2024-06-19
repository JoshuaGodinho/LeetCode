class Solution {
    public int majorityElement(int[] nums) {
        int value=nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(HashMap.Entry<Integer, Integer> entry:map.entrySet()){
            if(entry.getValue()>value)
                return entry.getKey();
        }

        return -1;
    }
}