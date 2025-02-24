class Solution {
    public int[][] merge(int[][] intervals) {

        // for(int [] arr : intervals){
        //     Arrays.sort(arr);   
        // } -> wrong because internally it is already sorted just we need to sort on the basis of starting element

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<int [] > list = new ArrayList<>();

        int [] currentInterval = intervals[0];
        list.add(currentInterval);

        for(int i=1;i<intervals.length;i++){
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(intervals[i][0] <= currentInterval[1]){
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }else{
                currentInterval = intervals[i];
                list.add(currentInterval);
            }
        }
        int[][] ans = list.toArray(new int[list.size()][]);
        return ans;
    }
}