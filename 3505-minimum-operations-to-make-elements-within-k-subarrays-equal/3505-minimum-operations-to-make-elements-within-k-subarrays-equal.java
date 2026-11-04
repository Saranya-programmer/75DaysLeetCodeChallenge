import java.util.*;

class Solution {
    class Window {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        long lowSum = 0, highSum = 0;
        int lowSize = 0, highSize = 0;
        int target;

        Window(int x) {
            target = (x + 1) / 2;
        }

        void addMap(TreeMap<Integer, Integer> map, int v) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int v) {
            int count = map.get(v);
            if (count == 1) map.remove(v);
            else map.put(v, count - 1);
        }

        void moveLowToHigh() {
            int v = low.lastKey();
            removeMap(low, v);
            lowSum -= v;
            lowSize--;

            addMap(high, v);
            highSum += v;
            highSize++;
        }

        void moveHighToLow() {
            int v = high.firstKey();
            removeMap(high, v);
            highSum -= v;
            highSize--;

            addMap(low, v);
            lowSum += v;
            lowSize++;
        }

        void balance() {
            while (lowSize > target) {
                moveLowToHigh();
            }

            while (lowSize < target && highSize > 0) {
                moveHighToLow();
            }
        }

        void add(int v) {
            if (lowSize == 0 || v <= low.lastKey()) {
                addMap(low, v);
                lowSum += v;
                lowSize++;
            } else {
                addMap(high, v);
                highSum += v;
                highSize++;
            }
            balance();
        }

        void remove(int v) {
            if (low.containsKey(v)) {
                removeMap(low, v);
                lowSum -= v;
                lowSize--;
            } else {
                removeMap(high, v);
                highSum -= v;
                highSize--;
            }
            balance();
        }

        long cost() {
            long median = low.lastKey();
            return median * lowSize - lowSum
                    + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int windows = n - x + 1;
        long[] cost = new long[windows];

        Window window = new Window(x);

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.cost();

        for (int i = 1; i < windows; i++) {
            window.remove(nums[i - 1]);
            window.add(nums[i + x - 1]);
            cost[i] = window.cost();
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        Arrays.fill(dp[0], 0);

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];

                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}