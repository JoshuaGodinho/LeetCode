class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->
            Integer.compare(distance(b),distance(a))
        );

        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        int[][] result=new int[k][2];
        int index=0;
        while(!maxHeap.isEmpty())
            result[index++]=maxHeap.poll();
        
        return result;
    }

    public int distance(int[] point){
        return point[0]*point[0] +point[1]*point[1];
    }
}