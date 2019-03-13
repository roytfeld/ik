package ik.Set4;

import java.util.Iterator;

public class WordLadder {

    public static void main(String[] args) {
	// write your code here
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        DFS(g);
    }

    public static void DFS(Graph g) {
        if (g == null) return;
        boolean visited[] = new boolean[g.V];
        DFSUtil(g, 2, visited);
    }

    public static void DFSUtil(Graph g, int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = g.adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(g, n, visited);
        }
    }
}
