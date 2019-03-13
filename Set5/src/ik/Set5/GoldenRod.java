package ik.Set5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GoldenRod {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try {
            int arraySize = Integer.parseInt(scan.nextLine().trim());
            int[][] arr = new int[arraySize][2];
            for (int i = 0; i<arraySize; i++) {
                String[] prices = scan.nextLine().split(" ");
                arr[i][0] = Integer.parseInt(prices[0]);
                arr[i][1] = Integer.parseInt(prices[1]);
            }

            bw.write("Final array: ");
            bw.newLine();
            for (int value: arr[0]) {
                bw.write(value + " ");
            }
            bw.newLine();
            int k = Integer.parseInt(scan.nextLine().trim());
            int result = coinChange(k, arr);
            bw.write("The maximum sum you can get by dividing the rod of length "+k+" is "+result);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static int coinChange(int k, int[][] arr)  throws IOException {
        int[] table = new int[k+1];
        //table[0] = 0;
        StringBuffer path = new StringBuffer();
        for (int i = 1; i <= k; i++) {
            int diff = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][0] <= i) {
                    int max = Math.max(table[i],(table[(i - arr[j][0])]+arr[j][1]));
                    if (max > table[i]) {
                        table[i] = max;
                        diff = arr[j][1];
                    }

                }
            }
            bw.write("table["+i+"] = "+table[i]);
            bw.newLine();
            if (table[i]>table[i-1]) {
                path.append(diff+" ");
            }
        }
        bw.write(path.toString());
        bw.newLine();
        return table[k];
    }
}
