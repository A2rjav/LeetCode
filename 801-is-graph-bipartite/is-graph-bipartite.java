
class Solution {
    int n;
    boolean[] vis;
    boolean[] color;

    class Info {
        int v;
        boolean color;

        public Info(int v, boolean color) {
            this.v = v;
            this.color = color;
        }
    }

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        vis = new boolean[n];
        color = new boolean[n]; // To store the color of each node

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (!bfs(graph, i)) {  // If any component is not bipartite, return false
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int start) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(start, true));
        vis[start] = true;
        color[start] = true;

        while (!q.isEmpty()) {
            Info curr = q.poll();
            int node = curr.v;
            boolean col = curr.color;

            for (int neighbor : graph[node]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    color[neighbor] = !col; // Alternate color
                    q.add(new Info(neighbor, !col));
                } else if (color[neighbor] == col) {
                    return false; // Found two adjacent nodes with the same color → not bipartite
                }
            }
        }
        return true;
    }
}
