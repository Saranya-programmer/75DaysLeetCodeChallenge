class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1_000_000_007L;
        int[] count = new int[32];

        for (int num : nums) {
            for (int bit = 0; bit < 32; bit++) {
                if (((num >> bit) & 1) == 1) {
                    count[bit]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int bit = 31; bit >= 0; bit--) {
                if (count[bit] > 0) {
                    num |= (1L << bit);
                    count[bit]--;
                }
            }

            ans = (ans + num * num % MOD) % MOD;
        }

        return (int) ans;
    }
}