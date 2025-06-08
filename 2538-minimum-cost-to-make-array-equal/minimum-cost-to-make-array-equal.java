class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n=nums.length;
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums[i];
            arr[i][1]=cost[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a->a[0])); //[1,2,3,5]

        long totalCost=0;
        for(int i=0;i<n;i++)
        {
            totalCost+=arr[i][1];//20
        }

        long prefixCost=0;
        int median=arr[0][0];

        for(int i=0;i<n;i++)
        {
            prefixCost+=arr[i][1];
            if(prefixCost*2>=totalCost)
            {
                median=arr[i][0];
                break;
            }
        }

        long result = 0;
    for (int i = 0; i < n; i++) {
        result += (long)Math.abs(nums[i] - median) * cost[i];
    }
    return result;

    }
}