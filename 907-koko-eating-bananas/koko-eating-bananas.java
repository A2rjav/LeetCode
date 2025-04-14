class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();

        while(start <= end){
            int mid = start + (end - start )/2;
            int hours = calculateTotalHours(piles,mid);
            if(hours <= h) end = mid-1;
            else start = mid+1;
        }
        return start;
    }
    public int calculateTotalHours(int []piles, int k){
        int hours =0;
        for(int i=0;i<piles.length;i++){
            hours += Math.ceil((double)piles[i]/k);
        }
        return hours;
    }
}