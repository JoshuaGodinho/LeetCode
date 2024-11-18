class Solution {
    public int maxProfit(int[] prices) {
        int profitToday=0;
        int maxProfit=0;
        int low=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            low=Math.min(low,prices[i]);
            
            profitToday=prices[i]-low;
            
            maxProfit=Math.max(maxProfit, profitToday);
        }

        return maxProfit;
    }
}