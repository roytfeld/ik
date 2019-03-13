package ik.Set2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SubsetsOfASet {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try {
            String s = scan.nextLine().trim();
            if (s != null) {
                bw.write("All possible subsets of a set " + s);
                bw.newLine();
                SubsetsOfASet instance = new SubsetsOfASet();
                String[] ret = instance.generate_all_subsets(s);
                for (String line : ret) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public String[] generate_all_subsets(String s) {
        ArrayList<String> results = new ArrayList<>();
        doIterate(s, s.length(), 0, new StringBuilder(), results);
        return results.toArray(new String[0]);
    }

    public void doIterate(String s, int n, int i, StringBuilder preset, ArrayList<String> results) {
        if (i == n) {
            //we reached the end - no characters left to add
            results.add(preset.toString());
            return;
        }
        doIterate(s, s.length(), i + 1, preset, results);
        preset.append(s.charAt(i));
        doIterate(s, s.length(), i + 1, preset, results);
        preset.deleteCharAt(preset.length() - 1);
    }
}