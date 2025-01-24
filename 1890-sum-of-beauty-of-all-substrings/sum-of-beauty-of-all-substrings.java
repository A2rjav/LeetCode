class Solution {
    public int beautySum(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            int freq[] = new int[26];
            int maxFreq = 0;
            for(int j=i;j<s.length();j++){
                int curr = s.charAt(j)-'a';
                freq[curr]++;
                maxFreq = Math.max(maxFreq,freq[curr]);
                int minFreq = Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]>0){
                        minFreq = Math.min(minFreq,freq[k]);
                    } 
                }
                result += (maxFreq - minFreq);
            }
            
        }
        return result;
    }
}