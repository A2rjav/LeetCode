class Solution {
    boolean[] vis;
    ArrayList<ArrayList<Integer>> adj;

    public int countCompleteComponents(int n, int[][] edges) {
        vis = new boolean[n];
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, component);
                
                // Check if this component is a complete graph
                if (isComplete(component)) {
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int curr, ArrayList<Integer> component) {
        vis[curr] = true;
        component.add(curr);

        for (int neighbor : adj.get(curr)) {
            if (!vis[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }

    public boolean isComplete(ArrayList<Integer> component) {
        int size = component.size();

        
        for (int node : component) {
            if (adj.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
