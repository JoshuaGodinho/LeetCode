class Solution {
    private HashMap<Integer, List<Integer>> indices;
    private Random rand;

    public Solution(int[] nums) {
        this.rand=new Random();  
        this.indices=new HashMap<Integer,List<Integer>>();

        int len=nums.length;
        for(int i=0;i<len;i++){
            if(!this.indices.containsKey(nums[i]))
                this.indices.put(nums[i],new ArrayList<>());
            this.indices.get(nums[i]).add(i);
        }  
    }
    
    public int pick(int target) {
        int len=indices.get(target).size();
        int randomIndex=indices.get(target).get(rand.nextInt(len));
        return randomIndex;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */