class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        recurse(s,0,new ArrayList<>());
        return ans;

    }
    public void recurse(String s, int start, ArrayList<String> list){
        if(start == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                recurse(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
            
        }
        return true;
    }
}