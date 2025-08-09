class Solution {
    Integer[][]dp;
    int n;
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        dp = new Integer[n+1][n+1];
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(recurse(matrix,0,i),ans);
        }
        return ans;
    }
    public int recurse(int[][] matrix,int i,int j){
        if(i>=n || j>=n || i<0 || j<0) return Integer.MAX_VALUE;

        if(i==n-1) return matrix[i][j];
        if(dp[i][j] != null ) return dp[i][j];
        return dp[i][j] = matrix[i][j] + Math.min(recurse(matrix,i+1,j),Math.min(recurse(matrix,i+1,j-1),recurse(matrix,i+1,j+1)));
    }
}