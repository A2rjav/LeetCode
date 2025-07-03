class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+ nums[j]+nums[k];
                if(sum>0)k--;
                else if(sum<0) j++;
                else{
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                }
            }
        }
        ans.addAll(set);
            return ans;
    }
}