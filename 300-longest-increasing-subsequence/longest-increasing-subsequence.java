class Solution {
    int n;
    Integer dp[][];

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new Integer[n+1][n+1];
        return solve(nums,0,-1);
    }
    public int solve(int []nums,int i,int prev){

        if(i==n) return 0;

        if(dp[i][prev+1] != null ) return dp[i][prev+1];

        int take =0;
        if(prev == -1 || nums[i] > nums[prev]){
            take = solve(nums,i+1,i)+1;
        }
        
        int notTake = solve(nums,i+1,prev);

        return dp[i][prev+1] = Math.max(take,notTake);
    }
}