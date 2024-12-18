class Solution {
    public String reverseWords(String s) {
        String list[] = s.split("\\s+");
        int n = list.length;
        for(int i=0;i<n/2;i++){
            String temp = list[i];
            list[i] = list[n-i-1];
            list[n-i-1] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(list[i]);
            if(i<n-1){
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}