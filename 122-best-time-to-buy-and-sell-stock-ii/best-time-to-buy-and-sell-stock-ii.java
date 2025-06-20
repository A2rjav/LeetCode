class Solution {
    Integer [][]dp;
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new Integer[n+1][2];

        return solve(prices,0,1);
    }
    public int solve(int []prices,int ind,int buy){

        if(ind == n) return 0;

        if(dp[ind][buy] != null ) return dp[ind][buy];
        
        if(buy == 1 ){

            int purchase = -prices[ind] + solve(prices,ind+1,0);
            int notPurchase = solve(prices,ind+1,1);

            return dp[ind][buy] = Math.max(purchase,notPurchase);
        }
        else{
            int sell = prices[ind] + solve(prices,ind+1,1);
            int notSell = solve(prices,ind+1,0);

            return dp[ind][buy] = Math.max(sell,notSell);
        }
    }
}