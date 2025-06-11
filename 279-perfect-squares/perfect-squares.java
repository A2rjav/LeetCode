class Solution {
    Integer dp[];
    public int numSquares(int n) {
        dp = new Integer[n+1];
        return cntSquares(n);
    }
    public int cntSquares(int n){
        if(n==0) return 0;

        if(dp[n] != null) return dp[n];
        int minCnt = Integer.MAX_VALUE;

        for(int i=1;i*i<= n;i++){
            int square = i*i;
            minCnt = Math.min(minCnt,1+cntSquares(n-square));
        }
        return dp[n] = minCnt;
    }


}