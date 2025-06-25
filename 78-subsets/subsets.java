class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        n= nums.length;
        backtrack(nums,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums,int i,ArrayList<Integer> list){
        if(i==n){
            ans.add(new ArrayList<>(list));
            return;
        } 
        
        list.add(nums[i]);
        backtrack(nums,i+1,list);
        list.remove(list.size()-1);
        backtrack(nums,i+1,list);
    }
}