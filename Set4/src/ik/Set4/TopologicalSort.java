package ik.Set4;

import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class TopologicalSort {

    public static void main(String[] args) {
	// write your code here
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //top_sort(g);
    }
/*
    public static Stack top_sort(Graph g) {
        if (g == null) return;
        Set visited = new TreeSet();
        Set onpath = new TreeSet();
        Stack result = new Stack();
        for (node: graph) {
            top_sort_util(g, visited, result, onpath);
        }
        return result;
    }

    public static void top_sort_util(Graph g, Set visited, Stack result, Set onpath) {
        if (node in onpath) {
            reaise excaption;
        }
        if (node in visited) {
            return;
        }
        visited.insert(node);
        for (neighbor in node.neigbors) {
            top_sort_util(g, visited, result, onpath);)
        }
        onpath.remove(node);
        result.push(node);
    }
    */
}
