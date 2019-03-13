package ik.Set4;

import java.util.LinkedList;

public class Graph
{
    public int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    public LinkedList<Integer> adj[];

    // Constructor
    Graph( int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge ( int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }
}