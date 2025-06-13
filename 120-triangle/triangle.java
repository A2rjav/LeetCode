class Solution {
    Integer [][]dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];
        return minSum(triangle,0,0);
    }
    public int minSum(List<List<Integer>> triangle,int r,int c){
        if(r==triangle.size()-1) return triangle.get(r).get(c);
        if(dp[r][c] != null ) return dp[r][c];

        int down = minSum(triangle,r+1,c);
        int diag = minSum(triangle,r+1,c+1);

        return dp[r][c] = triangle.get(r).get(c) + Math.min(down,diag);
    }
}