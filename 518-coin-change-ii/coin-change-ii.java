class Solution {
    int n;
    Integer dp[][];
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new Integer[n+1][amount+1];
        return recurse(coins,amount,0,0);
    }
    public int recurse(int []coins, int amt,int sum,int i){
        if(sum == amt ) return 1;
        if(sum > amt) return 0;
        if(i==n) return 0;
        if(dp[i][sum ]!= null ) return dp[i][sum];
        return dp[i][sum] = recurse(coins,amt,sum+coins[i],i) + recurse(coins,amt,sum,i+1);
    }
}