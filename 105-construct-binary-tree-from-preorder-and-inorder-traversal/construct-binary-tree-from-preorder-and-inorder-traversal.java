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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
        return null;
        int n = inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,n-1,inorder,0,n-1);

    }
    public TreeNode helper(int[] preorder,int preS, int preE, int[] inorder, int inS, int inE){
        if(preS>preE || inS>inE) return null;
        TreeNode root = new TreeNode(preorder[preS]);

        int rootIdx = map.get(preorder[preS]);
        int leftLen = rootIdx-inS;
        root.left = helper(preorder,preS+1,leftLen+preS,inorder,inS,rootIdx-1);

        root.right = helper(preorder,preS+leftLen+1,preE,inorder,rootIdx+1,inE);

        return root;
    }
}