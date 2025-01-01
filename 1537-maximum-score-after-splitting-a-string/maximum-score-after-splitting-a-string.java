class Solution {
    public int maxScore(String s) {
        int ans =Integer.MIN_VALUE;
        int nz=0,no =0,t1 =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                t1++;
            }
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == '0'){
                nz++;
            }else{
                no++;
            }
            int sum = nz + (t1-no);
            ans = Math.max(sum,ans);
        } 
        return ans;
    }
}