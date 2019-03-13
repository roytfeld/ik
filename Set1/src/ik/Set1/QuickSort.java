package ik.Set1;

import java.io.*;
import java.util.*;

public class QuickSort {

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
            DoSort(arr, 0, arr.length-1);
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

    public static void DoSort(int[] arr, int start, int end) throws IOException{
        if (start < end) {
            int newPivot = arr[new Random().nextInt(end - start + 1) + start];
            bw.write("Partitioning elements from "+start+" to "+end+" with the pivot "+newPivot);
            bw.newLine();
            int pivot = Partition(arr, start, end, newPivot);
            bw.write("Current array: ");
            for (Integer value: arr) {
                bw.write(value + " ");
            }
            bw.newLine();
            DoSort(arr, start, pivot-1);
            DoSort(arr, pivot+1, end);
        }
    }

    private static int Partition(int arr[], int start, int end, int pivot) {
        int i = start;
        int temp1, temp2;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                // Move all elements smaller than pivot ahead in the array
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if (arr[j] == pivot) {
                // Move the matched element to the end
                // This is why we don't go to the last element in the iteration.
                temp1 = arr[j];
                arr[j] = arr[end];
                arr[end] = temp1;
                j--;
            }
        }
        // Swap the matched element from the last position to its correct place
        // i
        temp2 = arr[i];
        arr[i] = arr[end];
        arr[end] = temp2;

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }
}
