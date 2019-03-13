package ik.Set4;

import java.io.*;
import java.util.*;

public class KnightTour {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static int minmoves = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rows = Integer.parseInt(scan.nextLine().trim());
        int cols = Integer.parseInt(scan.nextLine().trim());
        int start_row = Integer.parseInt(scan.nextLine().trim());
        int start_col = Integer.parseInt(scan.nextLine().trim());
        int end_row = Integer.parseInt(scan.nextLine().trim());
        int end_col = Integer.parseInt(scan.nextLine().trim());
        int res = find_minimum_number_of_moves(rows, cols, start_row, start_col, end_row, end_col);
        bw.write(String.valueOf(res));
        bw.newLine();
        bw.close();
    }

    public static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        int[][] board = new int[rows][cols];
        for (int[] columns: board) {
            Arrays.fill(columns, -1);
        }
        if (isSafe(start_row, rows, start_col, cols, board) && isSafe(end_row, rows, end_col, cols, board)) {
            //putting knight on the visited
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start_row, start_col, 0});
            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                if (board[current[0]][current[1]] == -1) {
                    if (end_row == current[0] && end_col == current[1]) {
                        //reached the target - returning tour length
                        return current[2];
                    }
                    //not found yet - tracing the way
                    board[current[0]][current[1]] = current[2];
                    queue.addAll(getAllCurrentNeighbors(rows, cols, current, board));
                }
            }
        }
        //if still not found
        return -1;
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    public static ArrayList<int[]> getAllCurrentNeighbors(int rows, int cols, int[] current, int[][] board) {
        /* xMove[] and yMove[] define next move of Knight.
        xMove[] is for next value of x coordinate
        yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        ArrayList<int[]> ret = new ArrayList<>();
        for(int i = 0; i < xMove.length; i++) {
            int nx = current[0] + xMove[i];
            int ny = current[1] + yMove[i];
            if (isSafe(nx, rows, ny, cols, board)) {
                ret.add(new int[] {nx, ny, current[2]+1});
            }
        }
        return ret;
    }

    public static boolean isSafe(int x, int rows, int y, int cols, int[][] board) {
        return (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == -1);
    }
}
