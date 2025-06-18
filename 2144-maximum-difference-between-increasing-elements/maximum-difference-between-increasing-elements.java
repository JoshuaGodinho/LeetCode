/*
[87,68,91,86,58,63,43,98,6,40]
left=87
right=40
max=9
*/
class Solution {
    public int maximumDifference(int[] nums) {
        int low=nums[0];
        int max=-1;
        for(int right=1;right<nums.length;right++)
        {
            low=Math.min(low,nums[right]);
            if(nums[right]>low)
            {
                max=Math.max(max,nums[right]-low);
            }
        }

        return max;
    }
}