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
        int hd;
        int vd;
        Info(TreeNode node,int hd,int vd){
            this.node = node;
            this.hd = hd;
            this.vd = vd;
        }   
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root,0,0));
        while(!q.isEmpty()){
            int size= q.size(); 
            for(int i=0;i<size;i++){
                Info curr = q.remove();
                TreeNode node = curr.node;
                int hd = curr.hd;
                int vd = curr.vd;
                map.putIfAbsent(hd,new TreeMap<>());
                map.get(hd).putIfAbsent(vd,new ArrayList<>());
                map.get(hd).get(vd).add(node.val);
                if(node.left!= null) q.add(new Info(node.left,hd-1,vd+1));
                if(node.right!= null) q.add(new Info(node.right,hd+1,vd+1));
            }
        }
        for (TreeMap<Integer, List<Integer>> verticalMap : map.values()) {
            List<Integer> verticalList = new ArrayList<>();
            for (List<Integer> nodes : verticalMap.values()) {
                Collections.sort(nodes); 
                verticalList.addAll(nodes);
            }
            ans.add(verticalList);
        }
            System.out.println(map);
        return ans;
    }
}