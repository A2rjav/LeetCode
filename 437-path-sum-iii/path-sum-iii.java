/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Long,Integer> map = new HashMap<>();
    int cnt=0;
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L,1);
        dfs(root,targetSum,0L);
        return cnt;
    }
    void dfs(TreeNode root,int targetSum,Long currSum){
        if(root == null ) return;
        currSum += root.val;

        Long complement = currSum - targetSum;
        cnt += map.getOrDefault(complement,0);

        map.put(currSum,map.getOrDefault(currSum,0)+1);

        dfs(root.left,targetSum,currSum);
        dfs(root.right,targetSum,currSum);

        map.put(currSum,map.get(currSum)-1);
    }
}