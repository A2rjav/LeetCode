class Solution {
    public int[] finalPrices(int[] prices) {
        int []arr = new int[prices.length];
        Stack <Integer> s = new Stack<>();
        int n = prices.length;
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && prices[i] < s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                arr[i] = prices[i];
            }else{
                arr[i] = prices[i] - s.peek();
            }
            s.push(prices[i]);
        }
        return arr;
    }
}