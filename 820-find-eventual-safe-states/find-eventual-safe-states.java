class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            revAdj.add(new ArrayList<>());
        }

        int indeg[]= new int[n];
        for(int i=0;i<n;i++){
            for(int it : graph[i]){
                // i -> it it -> i
                revAdj.get(it).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indeg[i] == 0) q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            for(int neighbor : revAdj.get(curr)){
                indeg[neighbor]--;
                if(indeg[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}