package ik.Set4;

public class CountIslands {
    public static void main(String[] args) {
        // write your code here
        int[][] matrix = new int[3][4];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 0;
        matrix[0][3] = 1;
        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = 0;
        matrix[1][3] = 1;
        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 1;
        matrix[2][3] = 0;

        System.out.println(doCount(matrix));
    }

    public CountIslands(Graph grid) {
    }

    public static int doCount(int[][] matrix) {
        int count = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    exhaust(matrix, i, j);
                }
            }
        }
        return count;
    }

    public static void exhaust(int[][] matrix, int i, int j) {
        if (i<0 || i==matrix.length || j < 0 || j == matrix[i].length) {
            return;
        }
        if (matrix[i][j]==0) {
            return;
        }
        matrix[i][j]=0;
        exhaust(matrix, i+1, j);
        exhaust(matrix, i-1, j);
        exhaust(matrix, i, j+1);
        exhaust(matrix, i, j+1);
    }
}
