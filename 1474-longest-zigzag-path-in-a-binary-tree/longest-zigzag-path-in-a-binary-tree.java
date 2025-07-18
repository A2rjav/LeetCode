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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null ) return 0;
        solve(root.left,0,1);
        solve(root.right,1,1);
        return max;
    }
    void solve(TreeNode root,int dir,int sum){
        if(root == null) return;

        max = Math.max(sum,max);
        if(dir == 0){
            solve(root.right,1,sum+1);
            solve(root.left,0,1);
        }else{
            solve(root.right,1,1);
            solve(root.left,0,sum+1);
        }

    }
}