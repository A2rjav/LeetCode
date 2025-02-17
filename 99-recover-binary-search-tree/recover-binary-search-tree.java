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
    ArrayList<TreeNode> list = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root == null ) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public void print(){
        for(TreeNode node : list){
            System.out.println(node.val);
        }
        
    }
    public void find(){
        TreeNode a=null,b=null;
        boolean flag = false;
        ArrayList<TreeNode> copy = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            copy.add(list.get(i));
        }
        Collections.sort(copy, (x, y) -> Integer.compare(x.val, y.val));

        for(int i=0;i<list.size();i++){
            if(list.get(i).val != copy.get(i).val && !flag){
                a = list.get(i);
                flag = true;
            }
            else if((list.get(i).val != copy.get(i).val) && flag){
                b = list.get(i);
            }
        }
        
        int value = a.val;
        a.val = b.val;
        b.val = value;
        

    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        print();
        find();
    }
}
