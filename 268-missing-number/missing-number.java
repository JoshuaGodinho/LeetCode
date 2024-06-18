class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        int shouldSum=n*(n+1)/2;
        for(int num:nums){
            sum+=num;
        }
        return (shouldSum-sum);
    }
}