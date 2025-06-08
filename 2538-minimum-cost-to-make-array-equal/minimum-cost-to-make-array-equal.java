class Solution {
    public long minCost(int[] nums, int[] cost) {
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;

        for(int num:nums)
        {
            minVal=Math.min(minVal,num);
            maxVal=Math.max(maxVal,num);
        }

        long left=minVal,right=maxVal;

        while(left<right)
        {
            long mid=left+(right-left)/2;

            long costMid=getCost(nums,cost,mid);
            long costMidPlus=getCost(nums,cost,mid+1);

            if(costMid<costMidPlus)
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return getCost(nums, cost,left);
    }

    private long getCost(int[] nums,int[] cost, long target)
    {
        long totalCost=0;
        for(int i=0;i<nums.length;i++)
        {
            totalCost+=(long)Math.abs((nums[i]-target)*cost[i]);
        }
        return totalCost;
    }
}