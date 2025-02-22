class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j =1; j<=i; j++){
                list.add(nCr(i-1,j-1));
            }
            ans.add(list);
        }
        return ans;
    }
    public int nCr(int n,int r){
        int res = 1;
        for(int i =0;i<r;i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return (int) res;
    }
}