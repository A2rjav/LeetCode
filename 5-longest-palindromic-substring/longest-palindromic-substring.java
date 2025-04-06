class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = s.substring(0, 1);
        for(int i=0;i<n;i++){
            String odd = lbs(i,i,s,n);
            String even="";
            if(i!= n-1){
                even = lbs(i,i+1,s,n);
            }
            if(odd.length() > ans.length()) ans = odd;
            if(even.length()> ans.length() ) ans = even;
        }
        return ans;

    }

    public String lbs(int i,int j,String s,int n){
        while(i>=0 && j<n){
            if(s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }
            else break;
        }
        return s.substring(i+1,j);
    }
}