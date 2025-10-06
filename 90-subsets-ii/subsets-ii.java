class Solution {
    int n;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);

        backtrack(nums,new ArrayList<>(),0);
        return ans;
    }
    public void backtrack(int [] nums, ArrayList<Integer> list, int start){
        ans.add(new ArrayList<>(list));
        
        for(int i= start;i<n;i++){
            
            if(i > start && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            backtrack(nums,list, i+1);
            list.remove(list.size()-1);
        }
        
    }
}