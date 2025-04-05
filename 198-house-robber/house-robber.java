class Solution {
    int n;
    Integer dp[];
    public int rob(int[] nums) {
        n = nums.length;
        dp = new Integer[n];
        return robRecurse(nums,0);
    }
    public int robRecurse(int []nums,int i){
        if(i>= n) return 0;

        if(dp[i] != null ) return dp[i];
        return dp[i] = Math.max(robRecurse(nums,i+2) + nums[i],robRecurse(nums,i+1));
    }
}