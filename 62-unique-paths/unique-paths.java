class Solution {
    Integer dp[][];
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        return countWays(m-1,n-1,dp);
    }
    public int countWays(int m,int n,Integer [][]dp){
        if(m<0 || n<0) return 0;
        if(m==0 && n==0) return 1;
        if(dp[m][n] != null ) return dp[m][n];
        return dp[m][n] = countWays(m-1,n,dp) + countWays(m,n-1,dp);
    }
}