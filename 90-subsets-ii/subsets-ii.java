class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        backtrack(nums,0,new ArrayList<>());
        System.out.println(ans);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> curr : ans) res.add(new ArrayList<>(curr));
        return res;
    }
    public void backtrack(int []nums,int i,ArrayList<Integer> list){
        if(i==n){
            ans.add(new ArrayList<>(list));
            return;
        }

        backtrack(nums,i+1,list);
        list.add(nums[i]);
        backtrack(nums,i+1,list);
        list.remove(list.size()-1);
    }
}