import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }

        if (k < 1) return -1;

        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[2], b[2])
        );

        int startRun = 1;
        dist[0][startRun] = 0;
        pq.offer(new long[]{0, startRun, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();

            int u = (int) cur[0];
            int run = (int) cur[1];
            long cost = cur[2];

            if (cost != dist[u][run]) continue;

            if (u == n - 1) return (int) cost;

            for (int[] e : adj[u]) {
                int v = e[0];
                int w = e[1];

                int nextRun = labels.charAt(u) == labels.charAt(v)
                    ? run + 1 : 1;

                if (nextRun > k) continue;

                long nextCost = cost + w;

                if (nextCost < dist[v][nextRun]) {
                    dist[v][nextRun] = nextCost;
                    pq.offer(new long[]{v, nextRun, nextCost});
                }
            }
        }

        return -1;
    }
}