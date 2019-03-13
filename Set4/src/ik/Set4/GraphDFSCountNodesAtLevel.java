package ik.Set4;

public class GraphDFSCountNodesAtLevel {

    public static void main(String[] args) {
        int V = 8;
        Graph g = new Graph(V);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(0, 7);
        g.addEdge(4, 6);
        g.addEdge(4, 5);
        g.addEdge(4, 2);
        g.addEdge(7, 3);
        int level = 2;
    }

    public static int NumOfNodes(Graph g, int level)
    {
        if (g == null) return 0;
        // To keep track of current level
        int curr_level = 0;
        // For keeping track of visited
        // nodes in DFS
        boolean[] visited = new boolean[g.V];
        // To store count of nodes at a
        // given level
        int numberOfNodes = 0;
        DFSUtil(g, 0, curr_level, level, numberOfNodes, visited);
        return numberOfNodes;
    }

    public static void DFSUtil(Graph g, int v, int curr_level, int level,
                               int numberOfNodes, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v+" ");
        if (level == curr_level) {
            numberOfNodes++;
        } else if (level < curr_level)
            return;
        else {
            // Recur for all the vertices adjacent to this vertex
            for (int n: g.adj[v]) {
                if (!visited[n]) {
                    curr_level++;
                    DFSUtil(g, n, curr_level, level, numberOfNodes, visited);
                }
            }
        }
        curr_level--;
    }
}
