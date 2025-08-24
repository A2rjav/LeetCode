class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = (left + right) >> 1;
        int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // Count cross pairs
        int end = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (end <= right && (long) nums[i] > 2L * nums[end]) {
                end++;
            }
            cnt += end - (mid + 1);
        }

        // Merge step
        merge(nums, left, mid, right);
        return cnt;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int t = 0; t < temp.length; t++) {
            nums[left + t] = temp[t];
        }
    }
}
