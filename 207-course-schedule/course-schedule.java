class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>()); 
        }

        int indeg[] = new int[numCourses];

        for(int [] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i] == 0) q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int neighbor : adj.get(curr)){
                indeg[neighbor]--;
                if(indeg[neighbor] == 0) q.add(neighbor);
            }
        }

        return cnt == numCourses;
    }
}