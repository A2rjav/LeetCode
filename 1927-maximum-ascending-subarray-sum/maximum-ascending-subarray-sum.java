class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum =nums[0];
        int maxSum = sum;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                sum += nums[i];
                maxSum = Math.max(sum,maxSum);
            }else{
                sum = nums[i];
            }
        }
        return maxSum;
    }
}