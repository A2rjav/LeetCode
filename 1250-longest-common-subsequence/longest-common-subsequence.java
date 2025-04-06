class Solution {
    int m,n;
    Integer dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        dp = new Integer[m+1][n+1];
        return lcs(0,0,text1,text2);
    }
    public int lcs(int i,int j,String s1,String s2){
        if(i == m || j== n) return 0;

        if(dp[i][j] != null ) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
             return dp[i][j] = 1 + lcs(i+1,j+1,s1,s2);
        }
        return dp[i][j] = Math.max(lcs(i+1,j,s1,s2), lcs(i,j+1,s1,s2));
    }
}