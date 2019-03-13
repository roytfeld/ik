package ik.Set2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PossibleToAchieveTargetSum {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try {
            int arraySize = Integer.parseInt(scan.nextLine().trim());
            long[] arr = new long[arraySize];
            for (int i = 0; i<arraySize; i++) {
                arr[i] = Long.parseLong(scan.nextLine().trim());
                bw.write("Argument "+arr[i]+" added to the array");
                bw.newLine();
            }
            bw.write("Final array: ");
            bw.newLine();
            for (Long value: arr) {
                bw.write(value + " ");
            }
            bw.newLine();
            long k = Long.parseLong(scan.nextLine().trim());
            boolean result = check_if_sum_possible(arr, k);
            bw.newLine();
            if (result) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static boolean check_if_sum_possible(long[] arr, long k) {
        return doIterate(arr, k, 0, 0);
    }

    public static boolean doIterate(long[] arr, long k, int currentIndex, long currentSum) {
        if (currentIndex == arr.length) {
            return false; //reached the end of the array, and still no sum
        }
        if (currentSum == k) {
            return true; //found a match
        }

        boolean withoutit = doIterate(arr, k, currentIndex+1, currentSum); //skup elements > k
        currentSum += arr[currentIndex];
        boolean withit = doIterate(arr, k, currentIndex+1, currentSum);
        currentSum -= arr[currentIndex];
        return withit || withoutit;
    }
}