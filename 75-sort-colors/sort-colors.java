class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        quicksort(nums,0,n-1);
    }

    private void quicksort(int[] nums, int low , int high){
        if(low<high){
            int pivot=partition(nums, low, high);
            quicksort(nums,low, pivot-1);
            quicksort(nums, pivot+1,high);
        }
    }

    private int partition(int[] nums, int low, int high){
        int pivot=nums[high];
        int i=low-1;

        for(int j=low;j<high;j++){
            if(nums[j]<pivot){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,high);
        return (i+1);
    }

    private void swap(int[] nums, int i,int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}