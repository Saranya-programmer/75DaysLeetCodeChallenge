class Solution {
    class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    class Result {
        long score;
        int[] indices;

        Result(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Interval[] arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> in = intervals.get(i);

            arr[i] = new Interval(
                in.get(0),
                in.get(1),
                in.get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) {
                return Integer.compare(a.l, b.l);
            }
            return Integer.compare(a.r, b.r);
        });

        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = arr[i].l;
        }

        int[][] next = new int[n][1];

        for (int i = 0; i < n; i++) {
            next[i][0] = upperBound(starts, arr[i].r);
        }

        Result[][] dp = new Result[n + 1][5];

        for (int c = 0; c <= 4; c++) {
            dp[n][c] = new Result(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c <= 4; c++) {

                Result skip = dp[i + 1][c];
                Result best = skip;

                if (c < 4) {
                    int j = next[i][0];

                    Result takeNext = dp[j][c + 1];

                    int[] chosen = new int[takeNext.indices.length + 1];
                    chosen[0] = arr[i].idx;

                    for (int x = 0; x < takeNext.indices.length; x++) {
                        chosen[x + 1] = takeNext.indices[x];
                    }

                    Arrays.sort(chosen);

                    Result take = new Result(
                        arr[i].w + takeNext.score,
                        chosen
                    );

                    best = better(best, take);
                }

                dp[i][c] = best;
            }
        }

        return dp[0][0].indices;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private Result better(Result a, Result b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        return compareLexicographically(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compareLexicographically(int[] a, int[] b) {
        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}