package ik.Set2;

import java.io.*;
import java.util.*;

public class Fibonacci {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim());
            int res = 1;
            if (n>1) {
                int[] memorization = new int[n];
                Arrays.fill(memorization, -1);
                //set up the first two elements
                memorization[0] = 0;
                memorization[1] = 1;
                Fibonacci instance = new Fibonacci();
                res = instance.doIterate(n, memorization);
            }
            bw.write("Fibonacci of "+n+" : "+res);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public int doIterate(int i, int[] memorization) {
        if(i==0 || i==1)
            return i;
        int result2 = memorization[i-2];
        if (result2 == -1) {
            result2=doIterate(i-2, memorization);
        }
        int result1 = memorization[i-1];
        if (result1 == -1) {
            result1=doIterate(i-1, memorization);
        }
        return result2+result1;
    }
}
