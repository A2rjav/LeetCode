class Solution {
    int n;
    public int minDays(int[] bloomDay, int m, int k) {
        n = bloomDay.length;
        if((long)m*k > n) return -1;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int day : bloomDay){
            start = Math.min(start,day);
            end = Math.max(end,day);
        }
        while(start < end){
            int mid = start + (end - start )/2;
            if(isPossible(bloomDay,m,k,mid)) end = mid;
            else start = mid+1;
        }
        return isPossible(bloomDay,m,k,start)?start:-1;
    }
    public boolean isPossible(int []bloomDay,int m, int k,int day){
        int cnt=0,bouqetCnt=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i] <= day){
                cnt++; 
            }else{
                bouqetCnt += (cnt/k);
                cnt =0;
            }
        }
        bouqetCnt += (cnt/k);
        return bouqetCnt >= m;
    }
}