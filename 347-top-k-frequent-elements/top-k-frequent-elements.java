class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap= new PriorityQueue<>((a,b)->
            a.getValue()-b.getValue()
        );

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            minHeap.add(entry);

            if(minHeap.size()>k)
                minHeap.poll();
        }

        int[] topKNumbers=new int[k];
        for(int i=0;i<k;i++){
            topKNumbers[i]=minHeap.poll().getKey();
        }

        return topKNumbers;
    }
}