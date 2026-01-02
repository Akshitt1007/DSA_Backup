package r_Graphs;

//Topological Sort
//https://www.geeksforgeeks.org/problems/topological-sort/1

import java.util.ArrayList;
import java.util.Stack;

public class b3_Topological_Sort_to_get_Order {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj ) {

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        // Call DFS for every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, adj, visited, stack);
            }
        }

        // Pop from stack to get topological order
        ArrayList<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }

        return order;
    }

    private void DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        ArrayList<Integer> neighbour = adj.get(node);

        for (int i=0 ; i<neighbour.size(); i++ ) {

            int currentNeighbour = neighbour.get(i);

            if (!visited[currentNeighbour]) {
                DFS(currentNeighbour, adj, visited, stack);
            }
        }

        // Push AFTER visiting all neighbours
        stack.push(node);
        // • Rule:
        //          Node must be pushed into stack ONLY AFTER
        //          all its dependent nodes are fully processed

        /*

            - if the order is like 2 -> 3 -> 1

            Meaning:
            – To do task 3, task 2 must be done first
            – To do task 1, task 3 must be done first

            - So we put this in last so that when the deeper calls are finished, and we reached our final node
            - we put it in stack
            - the stack would be like 1-3-2
            - since it follows LIFO so we are good

            - But we put it not put in the last
            - and put it just below the visited[node] = true;
            - stack would look like 2-3-1
            - since it follows LIFO it will give 1->3->2

            - example:
            - If the graphs connection are like :
                A -> C
                B -> C

            - if we put on top we first A, stack = A
            - then we reached C, stack = A-C

            - now for B
            - we reach B, Stack = A-C-B
            - then we reached C since its already visited , we won't add
            - we poll out => B -> C -> A

            - final order = B -> C -> A
            - which is incorrect
            - how can we do C if A is required first to do so
            - the correct order is A -> B -> C or B -> A -> C
         */
    }
}
