package ik.Set4;

import java.util.Stack;

public class GraphDFSIteractive {

    public static void main(String[] args) {
        // write your code here
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //traverse from the source 2
        BFS(g, 0);
    }

    public static void BFS(Graph g, int source) {
        if (g == null) return;
        boolean visited[] = new boolean[g.V];
        Stack<Integer> stack = new Stack<Integer>();
        visited[source] = true;
        stack.push(source);
        while (stack.size() != 0) {
            source = stack.pop();
            System.out.print(source + " ");
            for (int n: g.adj[source]) {
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
    }
}