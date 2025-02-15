class Solution {
    List<List<Integer>> ans;
    public void backTrack(int k, int n,int idx, List<Integer> list){
        if(k==0 && n ==0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<=9;i++){
            if(i > n)
            break;
            list.add(i);
            backTrack(k-1,n-i,i+1,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        backTrack(k,n,1,new ArrayList<>());
        return ans;
    }
}