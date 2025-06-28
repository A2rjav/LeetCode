class Solution {
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return ans;
    }

    public void backtrack(int []nums,int i,List<Integer> list){
        if(i==n) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        backtrack(nums,i+1,list);
        list.remove(list.size()-1);
        
        while(i+1 < n && nums[i] == nums[i+1]) i++;

        backtrack(nums,i+1,list);
        
    }
}