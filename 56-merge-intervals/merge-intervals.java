class Solution {
    public int[][] merge(int[][] intervals) {
        int n =intervals.length;
        if(n==1) return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<n;i++){
            int curr[] = intervals[i];
            int last[] = list.get(list.size()-1);
            if(curr[0]<=last[1]){
                last[1] = Math.max(curr[1],last[1]);
            }else
            list.add(intervals[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}