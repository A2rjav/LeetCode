class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0 || n == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() -1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}