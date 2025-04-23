/*
points = [[10,16],[2,8],[1,6],[7,12]]
Intervals
Sort the intervals
[[1,6],[2,8], [7,12], [10,16]]
if end[i]>start[i+1]
    there is an overlap
    overlap lies between start[i+1],end[i] //[2][6]

 [[2,6], [10,12]]


[[2,2],[4,4]]

[[1,6],[2,8], [7,12],[10,16]]
xStart=7
xEnd=12
firstEnd=12
*/


class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0)    return 0;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int arrows=1;
        int xStart,xEnd, firstEnd=points[0][1];

        for(int[] p:points)
        {
            xStart=p[0];
            xEnd=p[1];

            if(firstEnd<xStart)
            {
                arrows++;
                firstEnd=xEnd;
            }
        }

        return arrows;
    }
}