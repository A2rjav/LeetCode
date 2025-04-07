class Solution {
    int n;
    Integer[] dp;
    public int rob(int[] nums) {
        n = nums.length;
        dp = new Integer[n];
        return recurse(nums,0);
    }
    public int recurse(int []nums,int i){
        if(i>=n) return 0;
        if(dp[i] != null) return dp[i];

        return dp[i] = Math.max(recurse(nums,i+2) + nums[i], recurse(nums,i+1));
    }
}