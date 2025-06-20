class Solution {
    int n;
    Integer[][]dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new Integer[n][3];
        return solve(prices,0,0);
    }
    public int solve(int []prices,int i,int status){
        if(i== n ) return 0;
        
        if(dp[i][status] != null ) return dp[i][status];
        if(status == 0) return dp[i][status]=  Math.max(solve(prices,i+1,status),solve(prices,i+1,1)-prices[i]);
        else if(status == 1) return dp[i][status] = Math.max(solve(prices,i+1,status),solve(prices,i+1,2)+prices[i]);
        else return dp[i][status] = solve(prices,i+1,0);
    }
}