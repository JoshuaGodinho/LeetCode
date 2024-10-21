class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result=new ArrayList<>();
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(
            (a,b)->(a[0]+a[1])-(b[0]+b[1])
        );

        for(int i=0;i<Math.min(k,nums1.length);i++){
            minHeap.offer(new int[] {nums1[i], nums2[0],0});
        }

        while(k-->0 && !minHeap.isEmpty()){
            int[] currentPair=minHeap.poll();
            result.add(Arrays.asList(currentPair[0],currentPair[1]));

            int indexInNums2 = currentPair[2]; // Get the index of nums2
            if (indexInNums2 + 1 < nums2.length) {
                // If there's a next element in nums2, add that pair
                minHeap.offer(new int[] {currentPair[0], nums2[indexInNums2 + 1], indexInNums2 + 1});
            }
        }

        return result;
    }
}