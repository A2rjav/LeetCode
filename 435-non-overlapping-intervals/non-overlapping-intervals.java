class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int removals= 0;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);

        int n = intervals.length;
        int prevEnd = intervals[0][1];
        for(int i=1;i<n;i++){
            int start = intervals[i][0];
            if(start<prevEnd){
                removals++;
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return removals;
    }
}