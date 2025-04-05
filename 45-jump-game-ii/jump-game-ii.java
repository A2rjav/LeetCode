class Solution {
    int n;
    int [] dp;
    public int jump(int[] nums) {
        n = nums.length;
        dp = new int[n];

        if(n<=1) return 0;
        Arrays.fill(dp,-1);
        return recurJump(nums,0);
    }
    public int recurJump(int[] nums,int i){
        if(i>= n-1) return 0;

        if(dp[i] != -1 ) return dp[i];

        int minJumps = Integer.MAX_VALUE;
        for(int j=1;j<= nums[i] && i+j<n;j++){
            int jumpsFromNext = recurJump(nums,i+j);
            if(jumpsFromNext != Integer.MAX_VALUE)
            minJumps = Math.min(minJumps,1+jumpsFromNext);
        }
        return  dp[i] = minJumps;

    }
}