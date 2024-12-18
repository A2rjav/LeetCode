class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j = i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    arr[i] = prices[i] - prices[j];
                    break;
                }
                arr[i] = prices[i];
            }
        }
        arr[arr.length-1] = prices[arr.length-1];
        return arr;
    }
}