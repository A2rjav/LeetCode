class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l=0,r=0,sum =0,total =0,ans = 0;
        for(;r<n-k;r++){
            sum += cardPoints[r];
        }

        for(int a : cardPoints) total += a;

        ans = total - sum;
        while(r<n){
            sum += (cardPoints[r] - cardPoints[l]);
            l++;
            r++;
            ans = Math.max(ans,total - sum);
        }

        return ans;
    }
}