class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> a.length()-b.length());

        int n = words.length;
        int []dp = new int[n];
        Arrays.fill(dp,1);

        int maxI = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i],words[j]) && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i] > maxI) maxI = dp[i];
        }
        return maxI;
    }

    public boolean compare(String first,String second){
        if(first.length() != second.length() +1 ) return false;
        int i=0,j=0;
        while(i< first.length()){
            if(j<second.length() && first.charAt(i) == second.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return i == first.length() && j==second.length();
    }

}