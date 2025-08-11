class Solution {
    int n;
    Integer dp[][];
    public int minInsertions(String s) {
        n = s.length();
        dp = new Integer[n+1][n+1];
        return recurse(s,0,n-1);
    }
    public int recurse(String s,int i,int j){
        if(i>j) return 0;
        if(i==j) return 0;

        if(dp[i][j] != null ) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) dp[i][j] = recurse(s,i+1,j-1);
        else{
             dp[i][j] = Math.min(recurse(s,i+1,j)+1,recurse(s,i,j-1)+1);
        }
        return dp[i][j];
    }
}