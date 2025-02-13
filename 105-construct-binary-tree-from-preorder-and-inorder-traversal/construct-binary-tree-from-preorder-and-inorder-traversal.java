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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode buildTree(int []preorder, int preStart,int preEnd, int []inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = 0;
        for(int i=0;i<=inEnd;i++){
            if(inorder[i] == root.val){
                inRoot = i;
                break;
            }
        }

        int leftTreeLen = inRoot - inStart;
        root.left = buildTree(preorder,preStart+1,preStart+leftTreeLen, inorder,inStart,inRoot-1);
        root.right = buildTree(preorder,preStart+leftTreeLen +1,preEnd, inorder,inRoot+1,inEnd);
        return root;
    }
}