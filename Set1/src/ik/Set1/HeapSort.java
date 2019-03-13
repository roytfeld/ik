package ik.Set1;

import java.io.*;
import java.util.*;

public class HeapSort {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    private static PriorityQueue<Integer> q;

    public static void main(String[] args) throws IOException
    {
        try {
            int arraySize = Integer.parseInt(scan.nextLine().trim());
            int[] arr = new int[arraySize];
            for (int i = 0; i<arraySize; i++) {
                arr[i] = Integer.parseInt(scan.nextLine().trim());
                bw.write("Argument "+arr[i]+" added to the array");
                bw.newLine();
            }
            DoSort(arr);
            bw.write("Final array: ");
            bw.newLine();
            for (Integer value: arr) {
                bw.write(value + " ");
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static void DoSort(int arr[]) {
        int arraySize = arr.length;
        q = new PriorityQueue<>(arraySize, Collections.reverseOrder());
        for (Integer value: arr) {
            q.offer(value);
        }
        int i = 0;
        while (i < arr.length) {
            arr[i++]=q.poll();
        }
    }
}
