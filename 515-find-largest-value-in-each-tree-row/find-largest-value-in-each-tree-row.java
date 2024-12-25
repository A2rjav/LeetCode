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
    List <Integer> res;

    public void dfs(TreeNode root,int level){
        if(root!=null){
            int val = root.val;
            if(res.size() == level){
                res.add(level,val);
            }else{
                res.set(level,Math.max(res.get(level),val));
            }
            dfs(root.left,level+1);
            dfs(root.right,level+1);
        }
        
    }
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root,0);
        return res;
    }
}