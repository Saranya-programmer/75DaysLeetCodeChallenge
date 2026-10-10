import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;
        int n = nums1.length;
        long[] diff = new long[n];
        long sum = 0, max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }

        if (sum <= k) return 0;

        long left = 0, right = max;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long limit = left;
        long ans = 0;
        long used = 0;

        for (long d : diff) {
            if (d > limit) {
                used += d - limit;
                d = limit;
            }
            ans += d * d;
        }

        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] >= limit && limit > 0) {
                // Only reduce differences that remain at the limit.
                long original = diff[i];
                if (original >= limit) {
                    ans -= limit * limit;
                    ans += (limit - 1) * (limit - 1);
                    remaining--;
                }
            }
        }

        return ans;
    }
}