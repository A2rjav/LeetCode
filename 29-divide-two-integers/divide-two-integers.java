class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int ans = 0;
        boolean sign = true;
        if(dividend <0 && divisor>=0) sign = false;
        if(divisor <0 && dividend>=0) sign = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        while(n>=d){
            int cnt = 0;
            while(n>= (d<<(cnt+1))){
                cnt++;
            }
            ans += 1<<cnt;
            n -= (d << cnt);
        }
        return sign ? ans:-ans;
    }
}