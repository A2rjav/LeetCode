class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int j = i+1;
            int k = n-1;

            while(j<k){
                if(nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j++]);
                    list.add(nums[k--]);
                    ans.add(list);  
                    
                }
                else if(nums[j] + nums[k] + nums[i] > 0 ){
                    k--;
                }else
                j++;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
         res.addAll(ans);
         return res;
    }
}