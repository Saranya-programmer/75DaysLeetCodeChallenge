import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);

            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        int totalMasks = 1 << litterCount;
        int allCollected = totalMasks - 1;

        // maxEnergy[r][c][mask] = maximum energy
        // with which we reached (r,c) after collecting mask.
        int[][][] maxEnergy = new int[m][n][totalMasks];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }

        /*
         * Encoding:
         *
         * lower 6 bits  -> energy (0 to 50)
         * next bits      -> mask
         * remaining bits -> position
         */
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int startPos = sr * n + sc;

        int startState =
                ((startPos << litterCount) | 0) << 6
                | energy;

        queue.offer(startState);
        maxEnergy[sr][sc][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int state = queue.poll();

                int remainingEnergy = state & 63;

                int temp = state >>> 6;

                int mask = temp & (totalMasks - 1);

                int pos = temp >>> litterCount;

                int r = pos / n;
                int c = pos % n;

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                // Cannot move anymore unless standing on R.
                if (remainingEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    // Obstacle
                    if (cell == 'X') {
                        continue;
                    }

                    int newEnergy = remainingEnergy - 1;
                    int newMask = mask;

                    // Collect litter
                    if (cell == 'L') {
                        int id = litterId[nr][nc];
                        newMask |= (1 << id);
                    }

                    // Reset energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    /*
                     * If we have already reached this state with
                     * at least as much energy, this state is useless.
                     */
                    if (newEnergy <= maxEnergy[nr][nc][newMask]) {
                        continue;
                    }

                    maxEnergy[nr][nc][newMask] = newEnergy;

                    int newPos = nr * n + nc;

                    int newState =
                            ((newPos << litterCount) | newMask) << 6
                            | newEnergy;

                    queue.offer(newState);
                }
            }

            moves++;
        }

        return -1;
    }
}