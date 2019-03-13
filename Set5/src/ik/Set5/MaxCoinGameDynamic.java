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
        if (arr.length == 1) {
            return arr[0];
        }
        int dp[][] = new int[arr.length+2][arr.length+2];
        for (int i = arr.length; i >= 1; i--) {
            for (int j = 0; j <= arr.length; j++) {
                if (i==j) {
                    dp[i][j] = arr[i-1];
                }
                if (i < j) {
                    int v1 = Math.min(dp[i+1][j-1], dp[i+2][j]) + arr[i-1];
                    int v2 = Math.min(dp[i+1][j-1], dp[i][j-2]) + arr[j-1];
                    dp[i][j] = Math.max(v1,v2);
                }
            }
        }
        return dp[1][arr.length];
        //return game(arr, 0, arr.length-1, dp); //recursive with memorization
        /*
        for (int len=0; len<arr.length; len++) {
            for (int left=0; left<arr.length-len; left++) {
                int right = left+len-1;
                dp[left][right] = Math.max(
                        Math.min(dp[left+2][right], dp[left+1][right-1])+arr[left],
                        Math.min(dp[left+1][right-1], dp[left][right-2])+arr[right]);
            }
        }
        return dp[0][arr.length-1];
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
