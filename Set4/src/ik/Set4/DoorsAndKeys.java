package ik.Set4;

import java.io.*;
import java.util.*;

public class DoorsAndKeys {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] res;
        int grid_size = 0;
        grid_size = Integer.parseInt(scan.nextLine().trim());

        String[] grid = new String[grid_size];
        for(int i = 0; i < grid_size; i++) {
            String grid_item;
            try {
                grid_item = scan.nextLine();
            } catch (Exception e) {
                grid_item = null;
            }
            grid[i] = grid_item;
        }

        res = find_shortest_path(grid);
        int res_rowLength = res.length;
        for(int res_i = 0; res_i < res_rowLength; res_i++) {
            for(int res_j = 0; res_j < res[res_i].length; res_j++) {
                bw.write(String.valueOf(res[res_i][res_j]) + " ");
            }
            bw.newLine();
        }
        bw.close();
    }

    static int[][] find_shortest_path(String[] grid) {
        Node start = getStart(grid);
        if (start != null) {
            Node[][][] parent = new Node[grid.length+1][grid[0].length()+1][1025];
            //boolean[][][] visited = new boolean[b.length+1][b[0].length()+1][1025];

            //Map<Node, Node> parent = new HashMap<>();
            Queue<Node> queue = new ArrayDeque<>();
            Node end = null;
            boolean done = false;


            queue.add(start);
            //visited[start.r][start.c][start.w] = true;
            //parent.put(start, null);

            while(!queue.isEmpty() && !done){
                Node t = queue.remove();
                List<Node> ns = expand(grid, t);

                for(Node n : ns){
                    //if(!parent.containsKey(n)){
                    if(!n.equals(start) && parent[n.r][n.c][n.w] == null){
                        //parent.put(n, t);
                        //visited[n.r][n.c][n.w] = true;
                        parent[n.r][n.c][n.w] = t;
                        queue.add(n);

                        if(grid[n.r].charAt(n.c) == '+'){
                            done = true;
                            end = n;
                        }
                    }
                }
            }

            if (done) {
                List<int[]> path = getReversePath(parent, end);
                Collections.reverse(path);

                int[][] ans = new int[path.size()][];
                for(int i = 0; i < ans.length; i++){
                    ans[i] = path.get(i);
                }
                return ans;

            }
        }
        return new int[0][0];
    }

    private static class Node{
        int r;
        int c;
        int w;

        public Node(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }

        public boolean equals(Object o){
            if(o instanceof Node){
                Node n = (Node) o;
                return r == n.r && c == n.c && w == n.w;
            }
            return false;
        }

        public int hashCode(){
            int result = 31;
            result = 37 * result + r;
            result = 37 * result + c;
            result = 37 * result + w;
            return result;
        }

        public void addKey(char k){
            int diff = k-'a';
            w = w | (1 << diff);
        }

        public boolean allowsKey(char k){
            int diff = k-'a';
            return (w & (1 << diff)) != 0;
        }

    }

    static List<Node> expand(String[] map, Node p){
        List<Node> l = new ArrayList<>();
        char c = map[p.r].charAt(p.c);

        if(c == '#' || ((c >= 'A' && c <= 'J') && !p.allowsKey(c))){
            return l;
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for(int i = 0; i < dr.length; i++){
            int nr = p.r + dr[i];
            int nc = p.c + dc[i];

            if(nr >= 0 && nr < map.length && nc >= 0 && nc < map[nr].length()){
                l.add(new Node(nr, nc, p.w));
            }
        }

        if(c >= 'a' && c <= 'j'){
            for(Node n : l){
                n.addKey(c);
            }
        }

        return l;
    }

    static Node getStart(String[] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length(); j++){
                if(map[i].charAt(j) == '@'){
                    return new Node(i, j, 0);
                }
            }
        }
        return null;
    }

    static List<int[]> getReversePath(Node[][][] parent, Node end){
        List<int[]> l = new ArrayList<>();

        while(end != null){
            int[] d = {end.r, end.c};
            l.add(d);
            end = parent[end.r][end.c][end.w];
        }

        return l;
    }
}
