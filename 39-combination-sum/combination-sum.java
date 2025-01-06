import java.util.ArrayList;
import java.util.List;

class Solution {
    public void util(int[] arr, int idx, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            util(arr, idx, target - arr[idx], ans, ds);
            ds.remove(ds.size() - 1);
        }
        util(arr, idx + 1, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        util(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }
}
