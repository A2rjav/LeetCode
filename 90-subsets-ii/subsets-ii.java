import java.util.*;

class Solution {
    private List<List<Integer>> ans;
    private Set<String> set;

    public void subset(int[] nums, int idx, List<Integer> list) {
        if (idx == nums.length) {
            List<Integer> tempList = new ArrayList<>(list);
            Collections.sort(tempList); // Ensure the list is sorted
            if (set.add(tempList.toString())) {
                ans.add(tempList);
            }
            return;
        }
        list.add(nums[idx]);
        subset(nums, idx + 1, list);
        list.remove(list.size() - 1);
        subset(nums, idx + 1, list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        subset(nums, 0, new ArrayList<>());
        return ans;
    }
}
