class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);
        recurse(candidates, target, 0, new ArrayList<>(), 0);

        return ans;
    }
    public void recurse(int[] candidates, int target, int start, ArrayList<Integer> list, int sum){
        
        if(sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum >target){
            return;
        }

        for(int i= start;i<n;i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(sum + candidates[i]> target ) break;

            list.add(candidates[i]);
            recurse(candidates,target,i+1, list, sum + candidates[i]);
            list.remove(list.size()-1);
        }
        
    }
}