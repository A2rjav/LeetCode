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
    int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxLength;
    }
    int[] dfs(TreeNode root){
        if(root ==null)
        return new int[]{-1,-1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int leftGo = 1 + left[1];
        int rightGo = 1 + right[0];

        maxLength = Math.max(maxLength,Math.max(leftGo,rightGo));
        return new int[]{leftGo,rightGo};
    }
}