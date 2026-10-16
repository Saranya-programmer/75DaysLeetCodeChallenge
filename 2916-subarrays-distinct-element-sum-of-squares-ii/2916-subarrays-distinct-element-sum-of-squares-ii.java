class Solution {
    static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];
            update(1, 0, n - 1, prev, i, 1, sum, sq, lazy);

            ans = (ans + sq[1]) % MOD;
            last[nums[i]] = i + 1;
        }

        return (int) ans;
    }

    private void update(int node, int start, int end, int l, int r,
                        long val, long[] sum, long[] sq, long[] lazy) {
        if (r < start || end < l) return;

        if (l <= start && end <= r) {
            sq[node] = (sq[node] + 2 * val % MOD * sum[node] % MOD
                       + (end - start + 1L) * val % MOD * val % MOD) % MOD;
            sum[node] = (sum[node] + (end - start + 1L) * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }

        int mid = start + (end - start) / 2;
        push(node, start, end, sum, sq, lazy);

        update(node * 2, start, mid, l, r, val, sum, sq, lazy);
        update(node * 2 + 1, mid + 1, end, l, r, val, sum, sq, lazy);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    private void push(int node, int start, int end,
                      long[] sum, long[] sq, long[] lazy) {
        if (lazy[node] == 0 || start == end) return;

        int mid = start + (end - start) / 2;
        apply(node * 2, start, mid, lazy[node], sum, sq, lazy);
        apply(node * 2 + 1, mid + 1, end, lazy[node], sum, sq, lazy);

        lazy[node] = 0;
    }

    private void apply(int node, int start, int end, long val,
                       long[] sum, long[] sq, long[] lazy) {
        long len = end - start + 1L;
        sq[node] = (sq[node] + 2 * val % MOD * sum[node] % MOD
                    + len * val % MOD * val % MOD) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }
}