class Solution {
    int n;
    Integer dp[];
    public int numSquares(int n) {
        this.n =n;
        dp = new Integer[n+1];
        return countRecur(n);
        
    }
    public int countRecur(int x){
        if(x==0) return 0;
        if(x<0) return Integer.MAX_VALUE;

        if(dp[x] != null) return dp[x];

        int count =Integer.MAX_VALUE;
        for(int i=1; i*i<=x;i++){
            count = Math.min(count,countRecur(x-i*i)+1);
        }
        return dp[x] = count;
    }
}