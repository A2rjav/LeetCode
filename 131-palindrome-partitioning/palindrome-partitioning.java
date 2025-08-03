class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        ArrayList<String> list = new ArrayList<>();
        recurse(s,list,0);
        return ans;
    }
    public void recurse(String s,ArrayList<String> list,int idx){
        if(idx == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<n;i++){
            if(isPalindrome(s,idx,i)){
                list.add(s.substring(idx,i+1));
                recurse(s,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i++) != s.charAt(j--))
            return false;
        }
        return true;
    }
}