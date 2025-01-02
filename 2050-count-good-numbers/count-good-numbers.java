class Solution {
    public long mod = 1000000007;

    // Modular exponentiation by squaring
    public long pow(long n, long m) {
        long ans = 1;
        n = n % mod; // Take modulo initially to avoid overflow
        while (m > 0) {
            if (m % 2 == 1) { // If the current bit of m is 1
                ans = (ans * n) % mod;
            }
            n = (n * n) % mod; // Square the base
            m /= 2; // Move to the next bit
        }
        return ans;
    }

    public int countGoodNumbers(long n) {
        long e = (n + 1) / 2; // Number of even-indexed positions
        long o = n / 2;       // Number of odd-indexed positions

        // Calculate the result as (5^e % mod) * (4^o % mod) % mod
        long result = (pow(5, e) * pow(4, o)) % mod;

        return (int) result;
    }
}
