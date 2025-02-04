class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int left = 1;
        int right = nums[nums.length-1];

        while (left < right) {
            int mid = (right + left) / 2;
            int sum = 0;
            for (int n : nums) {
                sum += Math.ceil((double)n/mid);
            }
            if (sum > threshold) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
