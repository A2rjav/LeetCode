class Solution {
    Integer dp[][];
    public int uniquePaths(int m, int n) {
        dp = new Integer[m+1][n+1];
        return recurse(m-1,n-1);
    }
    public int recurse(int m,int n){
        if(m<0 || n<0) return 0;
        if(m==0 && n==0 ) return 1;
        if(dp[m][n] != null ) return dp[m][n];
        return dp[m][n] = recurse(m-1,n) + recurse(m,n-1);
    }
}