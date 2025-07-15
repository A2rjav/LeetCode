class Solution {
    int n;
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int nSpell = spells.length;
        n = potions.length;
        Arrays.sort(potions);
       int ans[] = new int[nSpell];
       for(int i=0;i<nSpell;i++){
            ans[i] = success(spells[i],potions,success);
       }
       return ans;
    }
    int success(int spell,int [] potions,long success){
        int i =0,j=n-1;
        int ans = 0;
        while(i<=j){
            int mid = (i + j)>>1;
            long prod =(long) potions[mid] * spell;
            if(prod>=success){
                ans =   Math.max(ans,n-mid);
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return ans;
    }
}