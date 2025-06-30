class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};

        int left = 0, right = n - 1;
        int[] ans = new int[]{-1, -1};

        // Find first occurrence
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        if (left >= n || nums[left] != target) return ans; // target not found
        ans[0] = left;

        // Find last occurrence
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }
        ans[1] = right;

        return ans;
    }
}
