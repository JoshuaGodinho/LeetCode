class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right=getMax(piles);

        int result=right;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(canFinish(piles,h,mid)){
                result=mid;
                right=mid-1;
            }
            else
                left=mid+1;
        }

        return result;
    }

    private boolean canFinish(int[] piles, int h, int mid){
        int hours=0;

        for(int pile:piles){
            hours+=Math.ceil((double)pile/mid);
        }

        return hours<=h;
    }

    private int getMax(int[] piles){
        int max=0;
        for(int pile:piles)
            max=Math.max(max,pile);

        return max;
    }
}