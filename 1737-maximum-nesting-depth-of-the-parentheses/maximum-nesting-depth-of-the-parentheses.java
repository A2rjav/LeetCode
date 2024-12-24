class Solution {
    public int maxDepth(String s) {
        int c =0;
        int maxC =0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                c++;
                maxC = Math.max(c,maxC);
            }else if(ch == ')'){
                c--;
            }
        }
        return maxC;
    }
}