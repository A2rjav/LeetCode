class Solution { 
        List<List<Integer>> out = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for(int i=0;i<Math.pow(2,n);i++){
            out.add(getNum(i, nums, n));
        }
        return out;
    }

    public List<Integer> getNum(int x, int num[], int n) {
        List<Integer> s = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if((x & 1 << i) != 0)
                s.add(num[i]);
        }
        return s;
    }
}