class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(start>newEnd){
                res.add(new int[]{newStart,newEnd});
                newStart = start;
                newEnd = end;
            }
            else if(end < newStart)
            res.add(new int[]{start,end});
            else{
                newStart = Math.min(newStart,start);
                newEnd = Math.max(newEnd,end);
            }
        }
        res.add(new int[]{newStart,newEnd});
        return res.toArray(new int[res.size()][]);
    }
}