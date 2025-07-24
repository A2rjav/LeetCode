class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<int[]>q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        q.add(new int[]{x,0});
        set.add(x);

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int n=curr[0];
            int step = curr[1];

            if(n == y) return step;

            if(n%11==0 && set.add(n/11))
            q.add(new int[]{n/11,step+1});

            if(n%5==0 && set.add(n/5))
            q.add(new int[]{n/5,step+1});

            if(set.add(n+1)){
                q.add(new int[]{n+1,step+1});
            }
            if(set.add(n-1))
            q.add(new int[]{n-1,step+1});
        }
        return -1;
    }
}