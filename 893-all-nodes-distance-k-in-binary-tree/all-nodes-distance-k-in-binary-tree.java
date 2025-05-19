    /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
    class Solution {
        Map<TreeNode,List<TreeNode>> graph = new HashMap<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            buildGraph(root,null);
            Set<TreeNode> vis = new HashSet<>();
            Queue<TreeNode> q = new LinkedList<>();
            List<Integer> res = new LinkedList<>();
            int dist = 0;

            q.add(target);
            vis.add(target);

            while(!q.isEmpty()){
                int size = q.size();
                if(dist == k){
                    for(TreeNode node : q) res.add(node.val);
                    return res;
                }
                for(int i=0;i<size;i++){
                    TreeNode curr = q.poll();
                    for(TreeNode neighbor : graph.getOrDefault(curr,new ArrayList<>())){
                        if(!vis.contains(neighbor)){
                            q.add(neighbor);
                            vis.add(neighbor);
                        }
                    }
                }
                dist++;
            }
            return res;
        }
        public void buildGraph(TreeNode root,TreeNode parent){
            if(root == null ) return;

            if(!graph.containsKey(root)){
                graph.put(root,new ArrayList<>());
                if(parent !=null){
                    graph.get(root).add(parent);
                    graph.get(parent).add(root);
                }
                buildGraph(root.left,root);
                buildGraph(root.right,root);
            }
        }
    }