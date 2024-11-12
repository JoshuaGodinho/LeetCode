class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> currentList=new ArrayList<>();
        boolean[] check=new boolean[nums.length];

        backtrack(results,currentList, nums,check);
        
        return results;
    }

    private void backtrack(List<List<Integer>> results,List<Integer> currentList,int[] nums,boolean[] check){
        if(currentList.size()==nums.length){
            results.add(new ArrayList<>(currentList));
            return;
        }
            
        for(int i=0;i<nums.length;i++){
            if(check[i]==true)
                continue;
            
            currentList.add(nums[i]);
            check[i]=true;
            backtrack(results,currentList, nums,check);

            currentList.remove(currentList.size()-1);
            check[i]=false;
        }
    }
}