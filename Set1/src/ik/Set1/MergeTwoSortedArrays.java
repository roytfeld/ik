package ik.Set1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class MergeTwoSortedArrays {
    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int ar1Size = Integer.parseInt(scan.nextLine().trim());
            int[] ar1 = new int[ar1Size];
            for (int i = 0; i<ar1Size; i++) {
                ar1[i] = Integer.parseInt(scan.nextLine().trim());
                bw.write("Argument "+ar1[i]+" added to the ar1");
                bw.newLine();
            }
            int ar2Size = Integer.parseInt(scan.nextLine().trim());
            int[] ar2 = new int[ar2Size];
            for (int i = 0; i<ar2Size; i++) {
                ar2[i] = Integer.parseInt(scan.nextLine().trim());
                bw.write("Argument "+ar2[i]+" added to the ar2");
                bw.newLine();
            }

            DoMerge(ar1, ar2, ar1Size, ar2Size);
            bw.write("Final ar1: ");
            bw.newLine();
            for (Integer value: ar1) {
                bw.write(value + " ");
            }
            bw.newLine();
            bw.write("Final ar2: ");
            bw.newLine();
            for (Integer value: ar2) {
                bw.write(value + " ");
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static void DoMerge(int[] ar1, int ar2[], int ar1Size, int ar2size) throws IOException{
        //See https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
        for (int j=ar2size-1; j>=0; j--) {
            int count = ar1Size-1, ar1last = ar1[ar1Size-1];
            while (count >0 && ar1[count]>ar2[j]) {

            }
        }
    }
}
