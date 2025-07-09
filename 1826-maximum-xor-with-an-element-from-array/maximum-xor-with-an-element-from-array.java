import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();
    int[] ans;

    public int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<Pair<Integer, Pair<Integer, Integer>>> list = new ArrayList<>();
        Arrays.sort(nums);
        int idx = 0;
        for (int[] query : queries) {
            list.add(new Pair<>(query[1], new Pair<>(query[0], idx++)));
        }
        Collections.sort(list, (a, b) -> a.getKey() - b.getKey());

        idx = 0;
        int n = queries.length;
        ans = new int[n];
        for (Pair<Integer, Pair<Integer, Integer>> it : list) {
            while (idx < nums.length && nums[idx] <= it.getKey()) {
                insert(nums[idx++]);
            }

            if (idx != 0) {
                ans[it.getValue().getValue()] = findMax(it.getValue().getKey());
            } else {
                ans[it.getValue().getValue()] = -1;
            }
        }
        return ans;
    }

    public void insert(int num) {
        TrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }
    }

    public int findMax(int num) {
        TrieNode curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int desired = 1 - bit;
            if (curr.children[desired] != null) {
                ans |= (1 << i);
                curr = curr.children[desired];
            } else {
                curr = curr.children[bit];
            }
        }
        return ans;
    }
}