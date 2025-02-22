class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i =0;i< nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j< k){
                List<Integer> list = new ArrayList<>();
                int sum = nums[j] + nums[k] + nums[i];
                if(sum> 0) k--;
                else if(sum < 0) j++;
                else {
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
            }
        }
        ans.addAll(set);
        return ans;
    }


}