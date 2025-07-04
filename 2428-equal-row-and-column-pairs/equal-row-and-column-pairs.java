class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(grid[i][j]);
            }
            map.put(list,map.getOrDefault(list,0)+1);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(grid[j][i]);
            }
            if(map.containsKey(list)){
                cnt+=map.get(list);
            }
        }
        return cnt;
    }
}