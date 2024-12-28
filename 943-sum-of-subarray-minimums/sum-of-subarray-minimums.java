class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;

        int n=arr.length;
        int [] prevSmaller = new int [n];
        int [] nextSmaller = new int[n];

        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                s.pop();
            }
            prevSmaller[i] = s.isEmpty() ? -1: s.peek();
            s.push(i);
        }
        s.clear();

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[i] <= arr[s.peek()] ){
                s.pop();
            }
            nextSmaller[i] = s.isEmpty() ? n:s.peek();
            s.push(i);
        }

        long ans =0;
        for(int i=0;i<n;i++){
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            ans = (ans + (left * right % mod) * arr[i]%mod)%mod;
        }

        return (int) ans;
    }
}