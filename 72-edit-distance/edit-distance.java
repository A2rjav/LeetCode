class Solution {
    Integer [][]dp;
    public int minDistance(String word1, String word2) {
        dp = new Integer[word1.length()+1][word2.length()+1];
        return lcs(0,0,word1,word2);
    }
    public int lcs(int i,int j, String w1,String w2){
        if(i == w1.length()) return w2.length() -j;
        if(j == w2.length()) return w1.length() -i;
        if(dp[i][j] != null ) return dp[i][j];

        int cost = Integer.MAX_VALUE;
        if(w1.charAt(i) == w2.charAt(j)) cost = Math.min(cost,lcs(i+1,j+1,w1,w2));
        else{
            cost = Math.min(cost,lcs(i+1,j+1,w1,w2)+1);
            cost = Math.min(cost,lcs(i+1,j,w1,w2)+1);
            cost = Math.min(cost,lcs(i,j+1,w1,w2)+1);
        }
        
        return dp[i][j] = cost;
    }
}