class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    long ways = (dp[j][0] + dp[j + 1][1]) % MOD;
                    dp[j + 1][0] = ways;
                    dp[j + 1][1] = ways;
                } else {
                    long right = dp[j + 1][1];
                    long down = dp[j][0];

                    dp[j + 1][0] = right;
                    dp[j + 1][1] = down;
                }
            }
        }

        return (int) dp[n][0];
    }
}