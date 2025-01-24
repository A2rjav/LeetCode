class Solution {
    public String reverseWords(String s) {
        String words [] = s.split("\\s+");
        int n = words.length;
        StringBuilder res = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            res.append(words[i]);
            if(i != 0){
                res.append(" ");
            }
        }
        return res.toString().trim();
        
    }
}