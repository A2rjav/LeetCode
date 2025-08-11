class Solution {
    int n;
    Integer[][]dp;
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        dp = new Integer[n+1][n+1];
        return recurse(s,0,n-1);
    }
    public int recurse(String s,int i,int j){
        if(i>j ) return 0;
        if(i==j) return 1;
        if(dp[i][j] != null ) return dp[i][j];
        if(s.charAt(i) == s.charAt(j))
        return dp[i][j] = 2 + recurse(s,i+1,j-1);
        else{
            return dp[i][j] = Math.max(recurse(s,i+1,j),recurse(s,i,j-1));
        }

    }
}