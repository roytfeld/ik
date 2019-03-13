package ik.Set1;

import java.io.*;
import java.util.*;

public class TopKNoDuplicates {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try {
            int arraySize = Integer.parseInt(scan.nextLine().trim());
            int[] arr = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                arr[i] = Integer.parseInt(scan.nextLine().trim());
                bw.write("Argument " + arr[i] + " added to the array");
                bw.newLine();
            }
            bw.write("Final array: ");
            bw.newLine();
            for (Integer value : arr) {
                bw.write(value + " ");
            }
            bw.newLine();
            int k = Integer.parseInt(scan.nextLine().trim());
            if (k < 1 || k > arr.length) {
                bw.write("Index K is not within range; aborting");
            }
            int[] result = TopK(arr, k);
            bw.newLine();
            bw.write("The "+k+" largest elements of the array are:");
            bw.newLine();
            for (int i = 0; i<result.length; i++) {
                bw.write(String.valueOf(result[i]));
                bw.newLine();
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    private static TreeSet<Integer> q;

    public static int[] TopK(int[] arr, int k) {
        q = new TreeSet<Integer>();
        for (int n : arr) {
            q.add(n);
            if (q.size() > k) {
                q.pollFirst();
            }
        }
        int ans[] = new int[q.size()];
        int ptr = 0;
        for (int x : q) {
            ans[ptr++] = x;
        }
        return ans;
    }
}

