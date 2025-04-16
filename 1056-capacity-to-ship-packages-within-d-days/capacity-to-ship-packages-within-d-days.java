class Solution {
    int n;
    public int shipWithinDays(int[] weights, int days) {
        n = weights.length;
        int max =0;
        int min = Integer.MIN_VALUE;
        for(int weight: weights){
            min = Math.max(weight,min);
            max+=weight;
        }

        while(min <= max){
            int mid = (min+max)>>1;
            int ans = calculateDays(weights,mid);
            if(ans >= days) min = mid+1;
            else max = mid-1;
        }
        return min;
    }
    public int calculateDays(int []weights,int weight){
        int sum =0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(sum + weights[i] > weight ){
                ans++;
                sum=0;
            }
            sum += weights[i];
        }
        return ans;
    }
}