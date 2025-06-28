class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        backtrack(nums,0,new ArrayList<>());
        return ans;       
    }
    public void backtrack(int []nums,int start,List<Integer> list){
        ans.add(new ArrayList<>(list));
        for(int i=start;i<n;i++){
            list.add(nums[i]);
            backtrack(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}