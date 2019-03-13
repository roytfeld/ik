package ik.Set1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestDuplicatesAllowed {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

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
            bw.write("Final array: ");
            bw.newLine();
            for (Integer value: arr) {
                bw.write(value + " ");
            }
            bw.newLine();
            int k = Integer.parseInt(scan.nextLine().trim());
            if (k<1 || k > arr.length) {
                bw.write("Index K is not within range; aborting");
            }
            int result = KthLargest(arr, k);
            bw.newLine();
            bw.write("The Kth largest element of the array is "+result);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    private static PriorityQueue<Integer> q;

    public static int KthLargest(int[] arr, int k) {
        q = new PriorityQueue<>(k);
        for (int n : arr) {
            add(n, k);
        }
        return q.peek();
    }

    public static void add(int n, int k) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
    }
}
