package ik.Set2;

import java.io.*;
import java.util.*;

public class NQueens {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim());
            if (n>3 && n<13) {
                bw.write("Possible queen combinations for the board of the size "+n);
                bw.newLine();
                NQueens instance = new NQueens();
                String[][] ret = instance.find_all_arrangements(n);
                for (String[] value: ret) {
                    for (String line: value) {
                        bw.write(line);
                        bw.newLine();
                    }
                    bw.newLine();
                }
            } else {
                bw.write("n is out of range");
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public String[][] find_all_arrangements(int n) {

        ArrayList<String[]> results = new ArrayList<>();
        int[] placement = new int[n];
        //set up the first two elements
        doIterate(n, placement, 0, results);
        String[][] ret = new String[results.size()][n];
        int i = 0;
        for (String[] value: results) {
            ret[i++] = value;
        }
        return ret;
    }

    public void doIterate(int n, int[] placement, int i, ArrayList<String[]> results)
    {
        if(i==n) {
            //we reached the end without conflicts - return
            results.add(printPlacement(n, placement));
            return;
        }
        for (int j=0; j<n; j++) {
            if(noconflict(placement, i, j)) {
                placement[i] = j;
                doIterate(n, placement, i+1, results);
            }
        }
    }

    public String[] printPlacement(int n, int[] placement)
    {
        String[] res = new String[n];
        int i = 0;
        for (Integer value: placement) {
            char[] temp = new char[n];
            Arrays.fill(temp, '-');
            if (value != null) {
                temp[value] = 'q';
            }
            res[i++] = String.copyValueOf(temp);
        }
        return res;
    }

    public boolean noconflict(int[] placement, int i, int j) {
        for(int k=0; k < i; k++){
            if(placement[k] == j || (Math.abs(i-k) == Math.abs(j-placement[k]))){
                return false;
            }
        }
        return true;
    }
}
