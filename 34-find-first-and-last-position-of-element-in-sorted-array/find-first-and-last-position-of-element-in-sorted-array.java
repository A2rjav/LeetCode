class Solution {
    int n;
    public int[] searchRange(int[] nums, int target) {
        n = nums.length;
        if(findFirst(nums,target)==n) return new int[]{-1,-1};
        return new int[]{findFirst(nums,target),findLast(nums,target)};
    }
    public int findFirst(int nums[],int target){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)>>1;

            if(nums[mid]==target){
                ans = mid;
                high = mid-1;
            }
            else if(nums[mid]> target){
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
    public int findLast(int nums[],int target){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)>>1;

            if(nums[mid]==target){
                ans = mid;
                low = mid+1;
            }
            else if(nums[mid]> target){
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

}