class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // dp[i][j] means number of ways s[i:] can form t[j:]
        int[][] dp = new int[n][m];

        // initialize dp array to -1 (meaning not computed yet)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return countWays(s, t, 0, 0, dp);
    }

    private int countWays(String s, String t, int i, int j, int[][] dp) {
        // if we matched all of t
        if (j == t.length()) {
            return 1;
        }

        // if we ran out of s but t is not fully matched
        if (i == s.length()) {
            return 0;
        }

        // if already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ways = 0;

        if (s.charAt(i) == t.charAt(j)) {
            // use s[i] + skip s[i]
            ways = countWays(s, t, i + 1, j + 1, dp) + countWays(s, t, i + 1, j, dp);
        } else {
            // skip s[i]
            ways = countWays(s, t, i + 1, j, dp);
        }

        dp[i][j] = ways;
        return ways;
    }
}
