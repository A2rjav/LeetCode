class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        dp = new Integer[amount +1];
        int ans = countCoins(coins,amount);
        return ans == Integer.MAX_VALUE ? -1:ans;
    }
    public int countCoins(int [] coins,int amount){
        if(amount == 0) return 0;
        if(amount<0) return Integer.MAX_VALUE;

        if(dp[amount] != null) return dp[amount];

        int min = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = countCoins(coins,amount-coin);
            if(res != Integer.MAX_VALUE) min = Math.min(min,1+res);
        }

        dp[amount] = min;
        return min;
    }
}