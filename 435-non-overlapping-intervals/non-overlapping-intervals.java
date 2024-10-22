class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int count=0;
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            final int[] interval=intervals[i];

            if(interval[0]<end){
                end=Math.min(interval[1],end);
                count++;
            }
            else{
                end=interval[1];
            }
        }

        return count;
    }
}