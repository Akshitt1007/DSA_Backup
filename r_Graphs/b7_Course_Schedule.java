package r_Graphs;

import java.util.ArrayList;


//207. Course Schedule
//https://leetcode.com/problems/course-schedule/description/


public class b7_Course_Schedule {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for( int i=0 ; i < numCourses ; i++ ){
            if( !visited[i] ){

                boolean chck = DFS( adj, visited, pathVisited, i );

                if( chck ){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean DFS( ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node ){

        visited[node] = true;
        pathVisited[node] = true;

        ArrayList<Integer> neighbour = adj.get(node);

        for( int i=0 ; i < neighbour.size(); i++ ){

            int x = neighbour.get(i);

            if( !visited[x] ){
                boolean chck = DFS( adj, visited, pathVisited, x );

                if( chck ){
                    return true;
                }
            }
            else if( visited[x] && pathVisited[x] ){
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}
