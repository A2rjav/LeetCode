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
    private int postIndex;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length-1;
        map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return construct(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode construct(int[] inorder, int[] postorder,int si, int ei){
        if(si > ei)
        return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);

        root.right= construct(inorder,postorder,rootIndex+1,ei);
        root.left = construct(inorder,postorder,si,rootIndex -1);

        return root;
    }
}