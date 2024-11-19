class Solution {
    private int[] original;
    private int[] array;
    private Random rand;
    public Solution(int[] nums) {
        original=nums.clone();
        array=nums.clone();
        rand=new Random();
    }
    
    public int[] reset() {
        array=original.clone();
        return array;
    }
    
    public int[] shuffle() {
        for(int i=array.length-1;i>0;i--){
            int j=rand.nextInt(i+1);
            swap(array,i,j);
        }

        return array;
    }

     private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */