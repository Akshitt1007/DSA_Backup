package r_Graphs;
import java.util.*;


//https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1

public class d4_Kruskal_Algorithm {
    public static void main(String[] args) {

    }
    static class disjointSet {

        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        public disjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int finding_ultimate_parent(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int up = finding_ultimate_parent(parent.get(node));
            parent.set(node, up);
            return up;
        }

        public void union_by_Rank(int u, int v) {

            int pu = finding_ultimate_parent(u);
            int pv = finding_ultimate_parent(v);

            if (pu == pv) return;

            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv);
            }
            else if (rank.get(pu) > rank.get(pv)) {
                parent.set(pv, pu);
            }
            else {
                parent.set(pu, pv);
                rank.set(pv, rank.get(pv) + 1);
            }
        }
    }

    static class tuple implements Comparable<tuple> {
        int u, v, w;

        public tuple(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(tuple other) {
            return this.w - other.w;
        }
    }

    static int kruskalMST(int V, int[][] edges) {

        ArrayList<tuple> edgeList = new ArrayList<>();

        // Convert int[][] to edge list
        for( int i=0; i<edges.length; i++ ){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            edgeList.add( new tuple( u, v,w) );
        }

        // Sort edges by weight
        Collections.sort(edgeList);

        disjointSet ds = new disjointSet(V);
        int sum = 0;

        for (int i = 0; i < edgeList.size(); i++) {
            int u = edgeList.get(i).u;
            int v = edgeList.get(i).v;
            int w = edgeList.get(i).w;

            if (ds.finding_ultimate_parent(u) != ds.finding_ultimate_parent(v)) {
                sum += w;
                ds.union_by_Rank(u, v);
            }
        }

        return sum;
    }

}
