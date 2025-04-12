class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
       return Math.max(maxConsecutiveChar(answerKey,k,'T'),maxConsecutiveChar(answerKey,k,'F'));
    }

    public int maxConsecutiveChar(String s,int k,char target){
        int l=0,c=0,maxLen =0;
        int n = s.length();
        for(int r=0;r<n;r++){
            if(s.charAt(r) != target) c++;

            while(c>k){
                if(s.charAt(l) != target) c--;
                l++;
            }

            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}