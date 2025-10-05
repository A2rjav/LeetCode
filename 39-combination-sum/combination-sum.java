class Solution {
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;

         recurse(candidates, target, 0,0, new ArrayList<>());
         return ans;
    }
    public void recurse(int[] candidates, int target, int i, int sum, ArrayList<Integer> list){
        if(sum == target){
                 ans.add(new ArrayList<>(list));
                 return;
        }
        if( sum > target ||i == n){
             return;
        }
        // if(candidates[i] + sum > target) return;
        
        list.add(candidates[i]);
        recurse(candidates,target, i, sum + candidates[i], list);
        list.remove(list.size()-1);
        recurse(candidates,target, i+1, sum , list);
    }
}