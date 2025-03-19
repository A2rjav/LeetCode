class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>()); 
        }

        int indeg[] = new int[numCourses];

        for(int prereq[] : prerequisites){
            int task = prereq[0];
            int pre = prereq[1];
            adj.get(pre).add(task); //pre -> task
            indeg[task]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i] == 0) q.add(i);
        }

        int completedCourses =0;
        while(!q.isEmpty()){
            int currentCourse = q.remove();
            completedCourses++;

            for(int neighbor : adj.get(currentCourse)){
                indeg[neighbor]--;
                if(indeg[neighbor] == 0) q.add(neighbor);
            }
        }

        return completedCourses == numCourses;
    }
}