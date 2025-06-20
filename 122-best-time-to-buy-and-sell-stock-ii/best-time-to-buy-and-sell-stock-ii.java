class Solution {
    int n;
    Integer dp[][];
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new Integer[n+1][2];
        return solve(prices,0,true);
    }
    public int solve(int []prices,int ind,boolean buy){
        if(ind == n) return 0;
        int profit = 0;

        if(dp[ind][buy ? 1:0] != null ) return dp[ind][buy ? 1:0];

        if(buy){
            profit = Math.max((solve(prices,ind+1,false) - prices[ind]), 0 + solve(prices,ind+1,true));
        }else{
            profit = Math.max(prices[ind] + solve(prices,ind+1,true), solve(prices,ind+1,false));
        }
        dp[ind][buy?1:0] = profit;
        return profit;
    }
}