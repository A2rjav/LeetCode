class Solution {
    public int maxDepth(String s) {
        int c =0;
        int maxC =0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                c++;
                if(maxC < c){
                    maxC = c;
                }
            }else if(ch == ')'){
                c--;
            }
        }
        return maxC;
    }
}