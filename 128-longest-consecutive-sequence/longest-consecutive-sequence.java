class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums)
            set.add(num);

        int maxLength=0;

        for(int num:nums){
            if(!set.contains(num-1)){
                int currentNum=num;
                int currentLength=1;
            

            while(set.contains(currentNum+1)){
                currentNum++;
                currentLength++;
            }

            maxLength=Math.max(maxLength,currentLength);
            }
        }

        return maxLength;
    }
}