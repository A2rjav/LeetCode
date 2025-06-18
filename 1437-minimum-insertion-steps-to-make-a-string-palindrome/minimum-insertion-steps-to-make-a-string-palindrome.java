class Solution {
    Integer dp[][];
    public int minInsertions(String s) {
        int n = s.length();
        dp = new Integer[n+1][n+1];
        int lps = lps(0,n-1,s);
        return n-lps;
    }
    public int lps(int i,int j,String s){
        if(i>j )return 0;
        if(i==j) return 1;

        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + lps(i+1,j-1,s);
        }else{
            int a = lps(i+1,j,s);
            int b = lps(i,j-1,s);
            return dp[i][j] = Math.max(a,b);
        }
    }
}