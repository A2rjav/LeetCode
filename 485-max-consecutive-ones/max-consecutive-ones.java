class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n= nums.length;
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) cnt = 0;
            else {
                cnt++;
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}