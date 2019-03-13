package ik.Set5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CoinChange {

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
            int k = Integer.parseInt(scan.nextLine().trim());
            int result = coinChange(k, arr);
            bw.write("Total # of ways to get sum "+k+" is "+result);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static int coinChange(int k, int[] arr)  throws IOException {
        int[] table = new int[k+1];
        table[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    table[i] += table[(i - arr[j])];
                }
            }
            bw.write("table["+i+"] = "+table[i]);
            bw.newLine();
        }
        return table[k];
    }

}
