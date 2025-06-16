class Solution {
    int n;
    int amount;
    Integer [][]dp;
    public int change(int amount, int[] coins) {
        n = coins.length;
        this.amount = amount;
        dp = new Integer[n+1][amount+1];
        return countCoins(0,coins,0);
    }
    public int countCoins(int sum,int []coins,int i){
        if(sum == amount) return 1;
        if(sum > amount || i == n) return 0;
        
        if(dp[i][sum] != null ) return dp[i][sum];

        int pick = countCoins(sum+ coins[i],coins,i);
        int notPick = countCoins(sum,coins,i+1);
        return  dp[i][sum] = pick + notPick;
    }
}