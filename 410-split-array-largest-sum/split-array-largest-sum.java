class Solution {
    int n;
    public int splitArray(int[] nums, int k) {
        n = nums.length;
        int min = Integer.MIN_VALUE;
        int max = 0;
        for(int num : nums){
            min = Math.max(min,num);
            max += num;
        }

        while(min <= max){
            int mid = (min+max)>>1;
            int ans = calculateArrays(nums,mid);
            if(ans <= k) max = mid-1;
            else min = mid+1;
        }
        return min;
    }
    public int calculateArrays(int[] nums, int total){
        int sum =0;
        int ans =1;
        for(int i=0;i<n;i++){
            if(sum + nums[i] > total){
                ans++;
                sum = 0;
            } sum += nums[i];
        }
        return ans;
    }
}