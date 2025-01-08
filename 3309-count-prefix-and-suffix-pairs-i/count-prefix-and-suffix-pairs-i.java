class Solution {
    public boolean isPrefixAndSuffix(String word1, String word2){
        int n1= word1.length();
        int n2 = word2.length();
        if(n1 > n2 ) {
            return false;
        }
        return word2.substring(0,n1).equals(word1) && word2.substring(n2-n1).equals(word1);
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count =0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
        
    }
}