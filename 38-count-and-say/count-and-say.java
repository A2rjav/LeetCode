class Solution {
    public String generateNext(String current){
        StringBuilder sb = new StringBuilder();
        int c=1;
        char prev = current.charAt(0);

        for(int i=1;i<current.length();i++){
            if(current.charAt(i) == prev) c++;
            else{
                sb.append(c).append(prev);
                c=1;
                prev = current.charAt(i);
            }
        }
        sb.append(c).append(prev);
        return sb.toString();
    }
    public String countAndSay(int n) {
        if (n<=0) return "";
        String result = "1";

        for(int i=1;i<n;i++){
            result = generateNext(result);
        }
        return result;
    }
}