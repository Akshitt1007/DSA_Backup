package r_Graphs;

//Alien_Dictionary
//https://www.geeksforgeeks.org/problems/alien-dictionary/1

import java.util.ArrayList;
import java.util.Stack;

public class b9_Alien_Dictionary {
    public static void main(String[] args) {

    }
    public String findOrder(String[] words) {

        int K = 26;

        // 1️⃣ Mark present characters
        boolean[] present = new boolean[K];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                present[word.charAt(j) - 'a'] = true;
            }
        }

        // 2️⃣ Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // 3️⃣ Create edges
        for (int i = 0; i < words.length - 1; i++) {

            String x = words[i];
            String y = words[i + 1];

            int len = Math.min(x.length(), y.length());
            boolean found = false;

            for (int p = 0; p < len; p++) {
                if (x.charAt(p) != y.charAt(p)) {
                    adj.get(x.charAt(p) - 'a')
                            .add(y.charAt(p) - 'a');
                    found = true;
                    break;
                }
            }

            // ❗ Invalid prefix case
            if (!found && x.length() > y.length()) {
                return "";
            }
        }

        // 4️⃣ DFS Topological Sort
        boolean[] visited = new boolean[K];
        boolean[] pathVisited = new boolean[K];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            if (present[i] && !visited[i]) {
                if (DFS(i, adj, present, visited, pathVisited, stack)) {
                    return ""; // cycle detected
                }
            }
        }

        // 5️⃣ Build result
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append((char) ('a' + stack.pop()));
        }

        return result.toString();
    }

    private boolean DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] present, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack) {

        visited[node] = true;
        pathVisited[node] = true;

        ArrayList<Integer> neighbours = adj.get(node);

        for (int i = 0; i < neighbours.size(); i++) {

            int neighbourNode = neighbours.get(i);

            if (!present[neighbourNode]) {
                continue;
            }

            if (!visited[neighbourNode]) {
                if (DFS(neighbourNode, adj, present, visited, pathVisited, stack))
                    return true;
            }
            else if (pathVisited[neighbourNode]) {
                return true; // cycle
            }
        }

        pathVisited[node] = false;
        stack.push(node);
        return false;
    }
}
/*

WHY DO WE USE `if (!present[nei]) continue;` IN DFS
────────────────────────────────────────────────────────────

1) WHAT `present[]` MEANS
------------------------------------------------------------
- `present[ch] = true`  → character exists in the alien language
- `present[ch] = false` → character never appears in any word

Example:
words = ["bdbc", "dbe", "bcebc", "e", "bedb"]

Present characters:
b, d, c, e

So:
present[b] = true
present[d] = true
present[c] = true
present[e] = true
All other letters (a, f, g, ... z) = false


2) WHY THIS IS NECESSARY EVEN AFTER MARKING `present[]`
------------------------------------------------------------
- Internally, we build an adjacency list of size 26 (a–z).
- That means the graph physically contains 26 nodes,
  even if the alien language uses only a few characters.
- DFS does NOT know which characters are real by itself.


3) WHAT DFS ACTUALLY DOES
------------------------------------------------------------
- DFS explores neighbours using indices from the adjacency list.
- Without filtering, DFS may:
  • Visit characters that never appear in the dictionary
  • Push them into the topo stack
  • Disturb the correct ordering of real characters


4) PURPOSE OF THIS LINE
------------------------------------------------------------
if (!present[nei]) continue;

Meaning:
- If this neighbour character does NOT exist in the language,
  skip it completely.
- Do not visit it.
- Do not push it into the stack.


5) WHAT BREAKS IF WE REMOVE THIS CHECK
------------------------------------------------------------
- DFS can traverse fake nodes (like x, y, z).
- Even if we skip printing them later,
  their traversal still affects stack order.
- Result: valid characters may appear in the wrong order.



*/

