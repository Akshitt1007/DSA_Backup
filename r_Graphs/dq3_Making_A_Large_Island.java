package r_Graphs;


//827. Making A Large Island
//https://leetcode.com/problems/making-a-large-island/description/
public class dq3_Making_A_Large_Island {
  // =======================
    // Disjoint Set Class
    // =======================
    static class DisjointSet {

        int[] parent;
        int[] size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUPar(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = findUPar(parent[node]);
            return parent[node];
        }

        public void unionBySize(int u, int v) {
            int pu = findUPar(u);
            int pv = findUPar(v);

            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    // =======================
    // Main Function
    // =======================
    public int largestIsland(int[][] grid) {

        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        // =======================
        // STEP 1: Union existing 1s
        // =======================
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 0) continue;

                int nodeNo = row * n + col;

                for (int k = 0; k < 4; k++) {
                    int newr = row + dr[k];
                    int newc = col + dc[k];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // =======================
        // STEP 2: Try flipping each 0
        // =======================
        int mx = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (grid[row][col] == 1) continue;

                java.util.HashSet<Integer> components = new java.util.HashSet<>();

                for (int k = 0; k < 4; k++) {
                    int newr = row + dr[k];
                    int newc = col + dc[k];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int parent = ds.findUPar(newr * n + newc);
                        components.add(parent);
                    }
                }

                int sizeTotal = 0;
                for (Integer parent : components) {
                    sizeTotal += ds.size[parent];
                }

                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        // =======================
        // STEP 3: All-1s case
        // =======================
        for (int cell = 0; cell < n * n; cell++) {
            mx = Math.max(mx, ds.size[ds.findUPar(cell)]);
        }

        return mx;
    }

    // =======================
    // Helper Function
    // =======================
    private boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

}

