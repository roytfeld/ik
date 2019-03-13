package ik.Set5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxCoinGameRecursive {

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
        return game(arr, 0, arr.length-1);
    }

    public static int game(int[] arr, int left, int right)  throws IOException {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return arr[left];
        }
        //now giving the opponent to chance to take left of right coin
        //If I take left
        int option1 = game(arr, left+2, right);
        int option2 = game(arr, left+1, right-1);
        //If I take right
        int option3 = game(arr, left+1, right-1);
        int option4 = game(arr, left, right-2);
        return Math.max(Math.min(option1, option2)+arr[left], Math.min(option3, option4)+arr[right]);
    }
}
