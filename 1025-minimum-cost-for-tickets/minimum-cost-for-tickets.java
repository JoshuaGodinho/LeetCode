class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> travelDays=new HashSet<>();
        for(int day:days)
            travelDays.add(day);
        
        int lastDay=days[days.length-1];
        int[] dp=new int[lastDay+1];

        for(int i=1;i<=lastDay;i++){
            if(!travelDays.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }
            dp[i]=Math.min(
                dp[i-1]+costs[0],
                Math.min(
                    dp[Math.max(0,i-7)]+costs[1],
                    dp[Math.max(0,i-30)]+costs[2]
                )
            );
        }

        return dp[lastDay];
    }
}