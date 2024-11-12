class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();

        backtrack(results, new ArrayList<>(), nums,0);

        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentList, int[] nums,int start){

        results.add(new ArrayList<>(currentList));

        for(int i=start;i<nums.length;i++){
            currentList.add(nums[i]);
            backtrack(results, currentList, nums,i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}