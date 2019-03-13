package ik.Set4;

import java.util.*;

public class GraphBFSDetectCycle {

    public static void main(String[] args) {
        // write your code here
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if(isCyclic(g))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https://www.geeksforgeeks.org/archives/18212
    private static boolean isCyclic(Graph g)
    {
        if (g == null) return false;
        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[g.V];
        boolean[] recStack = new boolean[g.V];
        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < g.V; i++)
            if (isCyclicUtil(g, i, visited, recStack))
                return true;

        return false;
    }

    private static boolean isCyclicUtil(Graph g, int i, boolean[] visited, boolean[] recStack)
    {
        if (recStack[i])
            return true;
        if (visited[i])
            return false;
        // Mark the current node as visited and
        // part of recursion stack
        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = g.adj[i];
        for (Integer c: children)
            if (isCyclicUtil(g, c, visited, recStack))
                return true;
        recStack[i] = false;
        return false;
    }
}
