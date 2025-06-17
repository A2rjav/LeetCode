class Solution {
    Integer dp[][];
    int n;
    String s;
    public int longestPalindromeSubseq(String s) {
        this.s = s;
        n = s.length();
        dp = new Integer[n][n];

        return solve(0,n-1);
    }
    public int solve(int i,int j){
        if(i>j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != null ) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) return dp[i][j] = 2 + solve(i+1,j-1);
        else{
            int a = solve(i+1,j);
            int b = solve(i,j-1);
            return dp[i][j] = Math.max(a,b);
        }
    }
}