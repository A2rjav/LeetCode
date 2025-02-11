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
    class Info{
        TreeNode node;
        int idx;
        public Info(TreeNode node,int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0));
        int ans =0;
        while(!q.isEmpty()){
            int size = q.size();
            int start= q.peek().idx;
            int end = start;
            for(int i=0;i<size;i++){
                Info curr = q.remove();
                TreeNode node = curr.node;
                int idx = curr.idx;
                end = idx;
                if(node.left != null)
                q.add(new Info(node.left,2*idx+1));
                if(node.right!= null)
                q.add(new Info(node.right,2*idx+2));
            }
            ans = Math.max(ans,end-start+1);
        }
        return ans;
    }
}