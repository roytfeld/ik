package ik.Set1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GroupTheNumbers {

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
            DoSort(arr);
            bw.write("Final array: ");
            bw.newLine();
            for (Integer value: arr) {
                bw.write(value + " ");
                bw.newLine();
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
        int left = 0, right= arraySize-1;
        while (right>left) {
            if (arr[right] % 2 == 0) {
                int tmp = arr[right];
                arr[right] = arr[left];
                arr[left] = tmp;
				/*
				left will always be increased and all values to the left of the left pointer will
				be even
				*/
                left++;
            } else {
				/*
				right will always be decreased and all values to the right of the right pointer
				will be odd
				*/
                right--;
            }
        }
    }
}
