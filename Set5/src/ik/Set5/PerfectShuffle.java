package ik.Set5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PerfectShuffle {

    private static final Scanner scan = new Scanner(System.in);
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try {
            String a = scan.nextLine().trim();
            bw.write("String A ="+a);
            bw.newLine();
            String b = scan.nextLine().trim();
            bw.write("String B ="+b);
            bw.newLine();
            String c = scan.nextLine().trim();
            bw.write("String C ="+c);
            bw.newLine();
            if(perfect_shuffle(a,b, c))
                bw.write("C is a perfect shuffle of A and B");
            else
                bw.write("C is not a perfect shuffle of A and B");
        } catch (NoSuchElementException e) {
            bw.write("No Input Data; aborting");
        }
        bw.close();
    }

    public static boolean perfect_shuffle(String a, String b, String c)  throws IOException {
        if (c.length() != (a.length()+b.length())) {
            return false;
        }
        boolean[][] table = new boolean[a.length()+1][b.length()+1]; //assumed to be initialized to false
        table[0][0] = true;
        for (int i = 0; i<a.length(); i++) {
            if (c.charAt(i) == a.charAt(i)) {
                table[i+1][0] = true;
            }
        }
        for (int j = 0; j<b.length(); j++) {
            if (c.charAt(j) == b.charAt(j)) {
                table[0][j+1] = true;
            }
        }

        return table[a.length()][b.length()];
    }

}
