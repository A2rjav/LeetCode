class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int prev[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        Arrays.fill(prev,-1);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }

        int maxLen = 0;
        int maxIdx = -1;
        for(int i=0;i<n;i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(maxIdx >= 0){
            ans.add(nums[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        Collections.reverse(ans);
        return ans;
    }
}