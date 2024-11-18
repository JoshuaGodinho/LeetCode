public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {  
            firstBuy = Math.max(firstBuy, -price); // The maximum profit after buying the first stock   
            firstSell = Math.max(firstSell, firstBuy + price); // The maximum profit after selling the first stock  
            secondBuy = Math.max(secondBuy, firstSell - price); // The maximum profit after buying the second stock     
            secondSell = Math.max(secondSell, secondBuy + price); // The maximum profit after selling the second stock  
        }

        return secondSell; // The maximum profit after completing at most two transactions
    }
}
