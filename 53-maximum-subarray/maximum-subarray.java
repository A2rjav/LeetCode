class Solution {
    public int maxSubArray(int[] num) {
        int sum = num[0];
        int maxSum = num[0];
        for(int i=1;i<num.length;i++){
            sum = Math.max(num[i],num[i]+sum);
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}