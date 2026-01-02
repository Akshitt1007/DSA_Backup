package r_Graphs;

import java.util.ArrayList;
import java.util.Stack;

//210. Course Schedule II
//https://leetcode.com/problems/course-schedule-ii/description/

// Here we just check for
public class b8_Course_Schedule_II {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, ArrayList<ArrayList<Integer>> adj ) {

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        Stack<Integer> stack = new Stack<>();

        for( int i=0 ; i<numCourses ; i++ ){
            if( !visited[i] ){
                boolean chck = DFS(adj, visited, pathVisited, i, stack );
                if( chck ){
                    return new int[0];
                }
            }
        }

        int[] order = new int[numCourses];

        for( int i=0 ; i<numCourses; i++ ){
            order[i] = stack.pop();
        }


        return order;
    }

    public boolean DFS( ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node , Stack<Integer> stack ){

        visited[node] = true;
        pathVisited[node] = true;

        ArrayList<Integer> neighbour = adj.get(node);
        for( int i=0 ; i < neighbour.size(); i++ ){

            int x = neighbour.get(i);

            if( !visited[x] ){

                boolean chck = DFS(adj, visited, pathVisited, x, stack);
                if( chck ){
                    return true;
                }
            }
            else if( pathVisited[x] ){
                return true;
            }
        }

        stack.push(node);
        pathVisited[node] = false;
        return false;
    }
}
