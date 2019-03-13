package ik.Set4;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class StringTransformation {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int wordsSize = Integer.parseInt(scan.nextLine().trim());
            String[] words = new String[wordsSize];
            for (int wordsItr = 0; wordsItr < wordsSize; wordsItr++) {
                String wordsItem = scan.nextLine();
                words[wordsItr] = wordsItem;
            }
            String start = scan.nextLine();
            String stop = scan.nextLine();
            String[] res = string_transformation(words, start, stop);
            for (String nexts : res) {
                bw.write(nexts);
                bw.newLine();
            }
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        } catch (NumberFormatException e) {
            bw.write("Invalid number; aborting");
        }
        bw.close();
    }

    public static String[] string_transformation(String[] words, String start, String stop) {

        return new String[] { "-1" };
    }
}
