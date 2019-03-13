package ik.Set2;

import java.io.*;
import java.util.*;

public class Factorial {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim());
            int res = 1;
            if (n>0) {
                Factorial instance = new Factorial();
                res = instance.doIterate(n);
            }
            bw.write("Factorial of "+n+" : "+res);
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public int doIterate(int i) {
        if(i==1)
            return 1;
        int result = i * doIterate((i-1));
        return result;
    }
}
