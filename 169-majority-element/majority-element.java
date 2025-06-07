/*
Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2
candiate=1
count=0

*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate =0;
        int count=0;

        for(int num:nums)
        {
            if(count==0)
                candidate=num;
            if(candidate==num)
                count++;
            else
                count--;
        }
        return candidate;
    }
}