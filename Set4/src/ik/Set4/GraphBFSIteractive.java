package ik.Set4;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFSIteractive {

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
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[source] = true;
        queue.add(source);
        while(queue.size() != 0) {
            source = queue.poll();
            System.out.print(source+" ");
            Iterator<Integer> i = g.adj[source].listIterator();
            while (i.hasNext())
            {
                int v = i.next();
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
