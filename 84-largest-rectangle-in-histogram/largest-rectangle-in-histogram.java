class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;

        for(int i=0;i<=heights.length;i++){
            int currHeight= (i==heights.length)?0:heights[i];

            while(!stack.isEmpty() && currHeight<heights[stack.peek()]){
                int index=stack.pop();
                int width= stack.isEmpty()?i:(i-stack.peek()-1);
                int area = heights[index]*width;
                maxArea=Math.max(maxArea,area );
            }
            stack.push(i);
        }
        return maxArea;
    }
}