package ik.Set1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class NutsAndBolts {
    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int nutsSize = Integer.parseInt(scan.nextLine().trim());
            int[] nuts = new int[nutsSize];
            for (int i = 0; i<nutsSize; i++) {
                nuts[i] = Integer.parseInt(scan.nextLine().trim());
                //bw.write("Argument "+nuts[i]+" added to the nuts rray");
                bw.newLine();
            }
            int boltsSize = Integer.parseInt(scan.nextLine().trim());
            int[] bolts = new int[boltsSize];
            for (int i = 0; i<boltsSize; i++) {
                bolts[i] = Integer.parseInt(scan.nextLine().trim());
                //bw.write("Argument "+bolts[i]+" added to the bolts array");
                bw.newLine();
            }

            DoSort(nuts, bolts, 0, nuts.length-1);
            //bw.write("Final match: ");
            bw.newLine();
            for (int i = 0; i<nutsSize; i++) {
                bw.write(nuts[i]+" "+bolts[i]);
                bw.newLine();
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static void DoSort(int[] nuts, int bolts[], int start, int end) throws IOException{
        if (start < end) {
            int nutsPivot = bolts[new Random().nextInt(end - start + 1) + start];
            //bw.write("Partitioning nuts elements from "+start+" to "+end+" with the pivot "+nutsPivot);
            bw.newLine();
            int pivot = Partition(nuts, start, end, nutsPivot);
            //bw.write("Current nuts array: ");
            for (Integer value: nuts) {
                //bw.write(value + " ");
            }
            bw.newLine();
            //bw.write("Partitioning bolts elements from "+start+" to "+end+" with the pivot "+nuts[pivot]);
            bw.newLine();
            Partition(bolts, start, end, nuts[pivot]);
            //bw.write("Current bolts array: ");
            for (Integer value: bolts) {
                //bw.write(value + " ");
            }
            bw.newLine();
            DoSort(nuts, bolts, start, pivot-1);
            DoSort(nuts, bolts, pivot+1, end);
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
