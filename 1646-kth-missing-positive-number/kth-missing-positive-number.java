class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1, j = 0, n = arr.length;

        while (k > 0) {
            if (j < n && arr[j] == i) {
                j++;
            } else {
                k--;
            }
            i++;
        }
        return i - 1;
    }
}
