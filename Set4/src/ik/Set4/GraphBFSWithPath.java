package ik.Set4;

import java.util.*;

public class GraphBFSWithPath {

    public static void main(String[] args) {
        // write your code here
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 4);
        g.addEdge(4, 2);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        //traverse from the source 2
        BFS(g, 0);
        printAllPaths(g, 0, 5);
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
        System.out.println();
    }

    // Prints all paths from
    // 's' to 'd'
    public static void printAllPaths(Graph g, int s, int d)
    {
        boolean[] isVisited = new boolean[g.V];
        ArrayList<Integer> pathList = new ArrayList<>();
        //add source to path[]
        pathList.add(s);
        //Call recursive utility
        printAllPathsUtil(g, s, d, isVisited, pathList);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private static void printAllPathsUtil(Graph g, Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {
        // Mark the current node
        isVisited[u] = true;
        if (u.equals(d))
        {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            isVisited[u]= false;
            return ;
        }
        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : g.adj[u])
        {
            if (!isVisited[i])
            {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(g, i, d, isVisited, localPathList);
                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }
        // Mark the current node
        isVisited[u] = false;
    }
}
