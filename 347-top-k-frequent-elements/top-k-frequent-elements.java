class Solution {
    public int[] topKFrequent(int[] nums, int k) { 
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums)
            map.put(num, map.getOrDefault(num,0)+1);

        PriorityQueue<Map.Entry<Integer,Integer>> topKElements=new PriorityQueue<>(
            (a,b)->a.getValue()-b.getValue()
        );

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            topKElements.add(entry);
            if(topKElements.size()>k)
                topKElements.poll();
        }

        int[] topNumbers=new int[k];
        for(int i=0;i<k;i++)
            topNumbers[i]=topKElements.poll().getKey();

        return topNumbers;
    }
}