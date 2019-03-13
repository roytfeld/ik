package ik.Set2;

import java.io.*;
import java.util.*;

public class ClimbTheStairs {
    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim()); //number of steps
            int stepsSize = Integer.parseInt(scan.nextLine().trim()); //array for possible skip steps
            if (stepsSize > 0 ) {
                int[] arr = new int[stepsSize];
                for (int i = 0; i<stepsSize; i++) {
                    arr[i] = Integer.parseInt(scan.nextLine().trim());
                    bw.write("Argument "+arr[i]+" added to the array");
                    bw.newLine();
                }
                int res = 0;
                if (n>0) {
                    ClimbTheStairs instance = new ClimbTheStairs();
                    res = instance.doIterate(n, arr);
                }
                bw.write("Number of ways to climb "+n+" stairs with given steps skipping is "+res);
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public int doIterate(int i, int[] arr) {
        if(i<0) {
            return 0;
        }
        if (i==0 || i==1) {
            return 1;
        }
        int result = 0;
        for (int j=0; j<arr.length; j++) {
            result += doIterate(i-arr[j], arr);
        }
        return result;
    }
}
