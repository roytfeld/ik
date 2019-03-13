package ik.Set5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxCoinGameDynamic {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try {
            int arraySize = Integer.parseInt(scan.nextLine().trim());
            int[] arr = new int[arraySize];
            for (int i = 0; i<arraySize; i++) {
                arr[i] = Integer.parseInt(scan.nextLine().trim());
                bw.write("Argument "+arr[i]+" added to the array");
                bw.newLine();
            }
            bw.write("Final array: ");
            bw.newLine();
            for (int value: arr) {
                bw.write(value + " ");
            }
            bw.newLine();
            int result = game(arr);
            bw.write("The best score for the first player is "+result);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static int game(int[] arr)  throws IOException {
        int dp[][] = new int[arr.length][arr.length];
        //return game(arr, 0, arr.length-1, dp); //recursive with memorization
        for (int len=0; len<arr.length; len++) {
            for (int left=0; left<arr.length-len; left++) {
                int right = left+len-1;
                dp[left][right] = Math.max(
                        Math.min(dp[left+2][right], dp[left+1][right-1])+arr[left],
                        Math.min(dp[left+1][right-1], dp[left][right-2])+arr[right]);
            }
        }
        return dp[0][arr.length-1];
/*
        // Create a table to store solutions of subproblems
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;
        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {

                // Here x is value of F(i+2, j),
                // y is F(i+1, j-1) and z is
                // F(i, j-2) in above recursive formula
                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z));
            }
        }

        return table[0][n - 1];
        */
    }

    public static int game(int[] arr, int left, int right, int[][] dp)  throws IOException {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            return arr[left];
        }
        //now giving the opponent to chance to take left of right coin
        //If I take left
        int option1 = game(arr, left+2, right, dp);
        int option2 = game(arr, left+1, right-1, dp);
        //If I take right
        int option3 = game(arr, left+1, right-1, dp);
        int option4 = game(arr, left, right-2, dp);
        dp[left][right] = Math.max(Math.min(option1, option2)+arr[left], Math.min(option3, option4)+arr[right]);
        return dp[left][right];
    }
}
