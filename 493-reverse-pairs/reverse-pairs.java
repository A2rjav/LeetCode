class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) >> 1;
        int cnt = 0;
        cnt += mergeSort(nums, left, mid);
        cnt += mergeSort(nums, mid + 1, right);
        cnt += countPairs(nums, left, mid, right);
        merge(nums, left, mid, right);
        return cnt;
    }

    // Count cross-pairs: i in [low..mid], j in [mid+1..high]
    private int countPairs(int[] nums, int low, int mid, int high) {
        int j = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2L * nums[j]) j++;
            cnt += j - (mid + 1);
        }
        return cnt;
    }

    // Merge two sorted halves into ascending order
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}
