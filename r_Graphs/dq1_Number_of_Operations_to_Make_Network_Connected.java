package r_Graphs;


//1319. Number of Operations to Make Network Connected
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

import java.util.ArrayList;
import java.util.List;

public class dq1_Number_of_Operations_to_Make_Network_Connected {


    static class disjointSet{

        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        public disjointSet( int n ){
            for( int i=0; i<=n; i++ ){
                rank.add(0);
                parent.add(i);
            }
        }

        public int finding_ultimate_parent( int node ){

            if( node == parent.get(node) ){
                return node;
            }

            int currParent = parent.get( node );
            int ultimateParent = finding_ultimate_parent( currParent );
            parent.set( node, ultimateParent );

            return ultimateParent;
        }

        public void union_by_Rank( int u, int v ){

            int ultimate_parent_u = finding_ultimate_parent( u );
            int ultimate_parent_v = finding_ultimate_parent( v );

            if( ultimate_parent_u == ultimate_parent_v ){
                return;
            }

            if( rank.get( ultimate_parent_u) < rank.get(ultimate_parent_v) ){
                parent.set(ultimate_parent_u, ultimate_parent_v );
            }
            else if( rank.get( ultimate_parent_u) > rank.get(ultimate_parent_v) ){
                parent.set(ultimate_parent_v, ultimate_parent_u );
            }
            else if( rank.get( ultimate_parent_u) == rank.get(ultimate_parent_v) ){
                parent.set(ultimate_parent_u, ultimate_parent_v );

                int ultimate_parent_rank = rank.get( ultimate_parent_v );
                rank.set(ultimate_parent_v, ultimate_parent_rank + 1 );
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        disjointSet tree = new disjointSet(n);

        int x = connections.length;
        int y = connections[0].length;

        int total_wire = 0;
        for( int i=0; i<x; i++ ){
            tree.union_by_Rank( connections[i][0], connections[i][1] );
        }


        int components = 0;
        for (int i = 0; i < n; i++) {
            if (tree.finding_ultimate_parent(i) == i) {
                components++;
            }
        }

        return components - 1;
    }

    // Using DFS
    public int makeConnected_Using_DFS(int n, int[][] connections) {

        int edges=connections.length;

        List<List<Integer>> adj=new ArrayList<>();//adjacency list

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }

        int vis[]=new int[n];

        int nC=0;//no of components

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                nC++;
                dfs(vis,adj,i);
            }
        }
        if(edges<n-1){
            return -1;//if the number of edges is less than the (no of vertices-1) it means that there are not enough edges to make the graph connected because the minimum no of edges to make a graph connected is n-1 where n is the no of vertices
        }
        else {
            return nC-1;//if there are enough no of vertices then the minimum no of operations is equal to (no of connected components -1)
        }
    }
    void dfs(int vis[],List<List<Integer>> adj,int node){

        vis[node]=1;

        List<Integer> ad=adj.get(node);

        for(int i:ad){
            if(vis[i]==0){
                dfs(vis,adj,i);
            }
        }
    }
}
