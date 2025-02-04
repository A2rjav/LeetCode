class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=1;
        int j = Arrays.stream(piles).max().getAsInt();

        while(i<j){
            int mid = i + (j-i)/2;
            int sum=0;
            for(int k=0;k<piles.length;k++){
                sum += Math.ceil((double)piles[k]/mid);
            }
            if (sum > h) {  
                i = mid + 1; 
            } else {
                j = mid; 
            }
        }
        return i;
    }
}