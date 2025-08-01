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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<n;i++)
        add(root,preorder[i]);
        return root;
    }
    public TreeNode add(TreeNode root,int value){
        if(root == null ) 
        return new TreeNode(value);
        if(root.val > value)
        root.left = add(root.left,value);
        else if(root.val < value) 
        root.right = add(root.right,value);
        return root;
    }
}