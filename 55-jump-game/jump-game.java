class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxI = 0;
        for(int i=0;i<n-1;i++){
            if(maxI < i) return false;
            maxI = Math.max(maxI,i+nums[i]);
        }
        return maxI >= n-1;
    }
}