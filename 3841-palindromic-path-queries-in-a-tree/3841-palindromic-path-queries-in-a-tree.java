import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[][] up;
    private int[] parent, depth, tin, tout, bit, mask;
    private int timer, LOG;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        LOG = 17;
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        mask = new int[n];
        up = new int[n][LOG];
        bit = new int[n + 2];

        Arrays.fill(parent, -1);

        char[] chars = s.toCharArray();

        buildTree(n, chars);

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        for (int u = 0; u < n; u++) {
            rangeXor(tin[u], tout[u], mask[u]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                int newMask = 1 << (p[2].charAt(0) - 'a');

                int delta = mask[u] ^ newMask;

                rangeXor(tin[u], tout[u], delta);
                mask[u] = newMask;
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int l = lca(u, v);

                int pathMask = pointQuery(tin[u])
                             ^ pointQuery(tin[v])
                             ^ mask[l];

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    private void buildTree(int n, char[] chars) {
        int[] stack = new int[n];
        int[] iter = new int[n];
        int top = 0;

        stack[0] = 0;
        parent[0] = 0;
        timer = 0;
        tin[0] = timer++;
        mask[0] = 1 << (chars[0] - 'a');

        while (top >= 0) {
            int u = stack[top];

            if (iter[u] < adj[u].size()) {
                int v = adj[u].get(iter[u]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                up[v][0] = u;
                mask[v] = 1 << (chars[v] - 'a');
                tin[v] = timer++;

                stack[++top] = v;
            } else {
                tout[u] = timer;
                top--;
            }
        }

        up[0][0] = 0;
    }

    private void rangeXor(int left, int right, int delta) {
        update(left + 1, delta);
        update(right + 1, delta);
    }

    private void update(int idx, int delta) {
        for (int i = idx; i < bit.length; i += i & -i) {
            bit[i] ^= delta;
        }
    }

    private int pointQuery(int idx) {
        int res = 0;

        for (int i = idx + 1; i > 0; i -= i & -i) {
            res ^= bit[i];
        }

        return res;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = LOG - 1; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return parent[u];
    }
}