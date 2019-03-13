package ik.Set2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FindWellFormedBrackets {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException
    {
        try {
            int n = Integer.parseInt(scan.nextLine().trim());
            if (n>3 && n<13) {
                bw.write("Possible well-formed brackets for the n="+n);
                bw.newLine();
                FindWellFormedBrackets instance = new FindWellFormedBrackets();
                String[] ret = instance.find_all_well_formed_brackets(n*2);
                for (String line: ret) {
                    bw.write(line);
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

    public String[] find_all_well_formed_brackets(int n) {
        ArrayList<String> results = new ArrayList<>();
        char[] placement = new char[n];
        //set up the first two elements
        doIterate(n, placement, 0,0, 0, results);
        return results.toArray(new String[0]);
    }

    public void doIterate(int n, char[] placement, int openCount, int closeCount, int index, ArrayList<String> results)
    {
        if (closeCount > openCount) {
            return; //cannot have close brackets preceeding open ones
        }
        if(index==n) {
            //we reached the end without conflicts - return
            if (openCount == closeCount) {
                results.add(String.copyValueOf(placement));
            }
            return;
        }
        placement[index] = '(';
        doIterate(n, placement, openCount+1,closeCount, index+1, results);
        placement[index] = ')';
        doIterate(n, placement, openCount, closeCount+1, index+1, results);

    }
}
