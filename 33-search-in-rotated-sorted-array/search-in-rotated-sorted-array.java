class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2; // Calculate the middle index
            
            if (nums[mid] == target) {
                return mid; // Return the index if the target is found
            }
            
            if(nums[mid]>=nums[left]){
                if(nums[left]<=target && target<=nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else{//nums[mid]<=nums[left]
                if(nums[mid]<=target && target<=nums[right])
                    left=mid+1;
                else
                    right=mid-1;
            }
            }

        
        return -1; 
    }
}