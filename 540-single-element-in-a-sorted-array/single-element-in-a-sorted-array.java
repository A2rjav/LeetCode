class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s=1;
        int e = nums.length-2;
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[1] != nums[0]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];

        while(s<=e){
            int mid = (s + e)>>1;
            if(nums[mid]!= nums[mid+1] && nums[mid] != nums[mid-1])
            return nums[mid];

            if((mid%2== 0 && nums[mid-1] == nums[mid] )|(mid%2 ==1 && nums[mid+1] == nums[mid]) ){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return -1;
    }
}