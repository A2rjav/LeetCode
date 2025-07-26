class Solution {
    // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    // Boolean vis[];
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        int indeg[] = new int[n];
        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            indeg[v]++;
        }
        List<Integer> res = new ArrayList<>();
        // Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i] == 0)
            res.add(i);
        }
        return res;
        
    }
}