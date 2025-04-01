class Solution {
    int n;
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recurse(nums,list,0);
        return ans;
    }
    public void recurse(int[] nums,List<Integer> list, int i){
        if(i == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        recurse(nums,list,i+1);
        list.remove(list.size()-1);
        recurse(nums,list,i+1);
    }
}