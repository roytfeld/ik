package ik.Set1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DutchNationalFlag {
    public static String RED = "Red";
    public static String WHITE = "White";
    public static String BLUE = "Blue";

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int arraySize = Integer.parseInt(scan.nextLine().trim());
            String[] arr = new String[arraySize];
            for (int i = 0; i<arraySize; i++) {
                arr[i] = scan.nextLine().trim();
                bw.write("Argument "+arr[i]+" added to the array");
                bw.newLine();
            }
            DoSort(arr);
            bw.write("Final array: ");
            bw.newLine();
            for (String value: arr) {
                bw.write(value);
                bw.newLine();
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static void DoSort(String arr[])  throws IOException
    {
        int arraySize = arr.length;
        bw.write("Sorting array of Red, White, and Blue with the count "+arraySize);
        bw.newLine();
        int red = 0, count = 0, blue= arraySize-1;
        String temp;
        while (count<=blue) {
            if (RED.equals(arr[count])) {
                bw.write("Swapping Red "+red+" with White "+count);
                bw.newLine();
                temp = arr[count];
                arr[count++]=arr[red];
                arr[red++]=temp;
            } else if (BLUE.equals(arr[count])) {
                bw.write("Swapping Blue "+blue+" with White "+count);
                bw.newLine();
                temp = arr[count];
                arr[count]=arr[blue];
                arr[blue--]=temp;
            } else if (WHITE.equals(arr[count])) {
                bw.write("Increment count of White "+count);
                bw.newLine();
                count++;
            }
        }
    }
}
