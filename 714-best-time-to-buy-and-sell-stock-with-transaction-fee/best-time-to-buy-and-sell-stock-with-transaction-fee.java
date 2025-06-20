class Solution {
    int n;
    Integer dp[][];
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new Integer[n][2];

        return solve(prices,fee,0,1);
    }
    public int solve(int []prices,int fee,int i,int buy){
        if(i == n) return 0;

        if(dp[i][buy] != null) return dp[i][buy];

        if(buy == 1) 
        return dp[i][buy] = Math.max(solve(prices,fee,i+1,buy),solve(prices,fee,i+1,0)-prices[i]);
        
        else
        return dp[i][buy] = Math.max(solve(prices,fee,i+1,buy),solve(prices,fee,i+1,1)+prices[i] - fee);
    }
}