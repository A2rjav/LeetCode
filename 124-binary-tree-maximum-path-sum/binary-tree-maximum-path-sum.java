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
    int sum = Integer.MIN_VALUE;
    public int maxSum(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(maxSum(root.left),0);
        int right = Math.max(maxSum(root.right),0);
        sum = Math.max(sum,left + right + root.val);
        return Math.max(left,right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return sum;
        
    }
}