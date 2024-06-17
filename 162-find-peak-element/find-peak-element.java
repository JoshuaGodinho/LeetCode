class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int[] newArray = new int[nums.length + 2];
        System.arraycopy(nums, 0, newArray, 1, nums.length);
        newArray[0]=Integer.MIN_VALUE;
        newArray[newArray.length-1]=Integer.MIN_VALUE;
        int i=1;
        int j=newArray.length-2;
        while(i<=j){
            if(newArray[i]>newArray[i-1] && newArray[i]>newArray[i+1])
                return (i-1);
            else if(newArray[j]>newArray[j-1] && newArray[j]>newArray[j+1])
                return (j-1);
            else
            {
                i++;
                j--;
            }
        }
        return 0;
    }
}