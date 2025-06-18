class Solution {
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        dp = new Integer[n1][n2];
        int lcs = lcs(word1,word2,n1-1,n2-1);
        System.out.println(lcs);
        return n1+n2-2*lcs;
    }
    public int lcs(String s1,String s2,int i,int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != null )return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + lcs(s1,s2,i-1,j-1);
        else{
            int a = lcs(s1,s2,i-1,j);
            int b = lcs(s1,s2,i,j-1);
            return dp[i][j] = Math.max(a,b);
        }
    }
}