class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int l=0;
        int r = nums.length-1;
        for(int i=r;i>=0;i--){
            if(Math.abs(nums[r]) > Math.abs(nums[l])) {
                ans[i]= nums[r]*nums[r];
                r--;
            }
            else{
                ans[i] = nums[l] * nums[l];
                l++;
            } 
        }
        return ans;
    }
}